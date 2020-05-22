package org.example;

import org.springframework.extensions.webscripts.Cache;
import org.springframework.extensions.webscripts.DeclarativeWebScript;
import org.springframework.extensions.webscripts.Status;
import org.springframework.extensions.webscripts.WebScriptRequest;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.alfresco.error.AlfrescoRuntimeException;
import org.alfresco.model.ContentModel;
import org.alfresco.repo.content.MimetypeMap;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.ContentWriter;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.StoreRef;
import org.alfresco.service.cmr.search.ResultSet;
import org.alfresco.service.cmr.search.SearchService;
import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.service.namespace.QName;
import org.apache.commons.io.FileUtils;

public class CustomFileUpload extends DeclarativeWebScript {
    private final String UPLOAD_FILE_PATH = "{someRandomFile}";
    private final String UPLOAD_DESTINATION = "workspace://SpacesStore/{someRandomNodeRef}";
    protected ServiceRegistry serviceRegistry;

    public ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }

    public void setServiceRegistry(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    protected Map<String, Object> executeImpl(WebScriptRequest req, Status status, Cache cache) {
        File file = new File(UPLOAD_FILE_PATH);
//      NodeRef parent = getCompanyHome();
        NodeRef parent = new NodeRef(UPLOAD_DESTINATION);
        String name = "name of file in Repository " + System.currentTimeMillis();

        Map<QName, Serializable> props = new HashMap<QName, Serializable>(1);
        props.put(ContentModel.PROP_NAME, name);

        // use the node service to create a new node
        NodeRef node = serviceRegistry.getNodeService().createNode(
                        parent,
                        ContentModel.ASSOC_CONTAINS,
                        QName.createQName(NamespaceService.CONTENT_MODEL_1_0_URI, name),
                        ContentModel.TYPE_CONTENT, props).getChildRef();

        // Use the content service to set the content onto the newly created
        // node
        ContentWriter writer = serviceRegistry.getContentService().getWriter(node, ContentModel.PROP_CONTENT, true);
        writer.setMimetype(MimetypeMap.MIMETYPE_TEXT_PLAIN);
        writer.setEncoding("UTF-8");
        String text = "";
        try {
            text = FileUtils.readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.putContent(text);

        Map<String, Object> model = new HashMap<String, Object>();
        if (status.getCode() == Status.STATUS_OK) {
            model.put("resultRepoWS", "File \"" + file.getName() + "\" uploaded successfully to the repository. Status: " + status.getCode());
            return model;
        } else {
            model.put("resultRepoWS", "There was an error while uploading document \"" + file.getName() + "\" - Status: " + status.getCode());
            return model;
        }
    }

    //If you want to test with CompanyHome first use this method instead of the NodeRef
    @SuppressWarnings("unused")
    private NodeRef getCompanyHome() {
        StoreRef storeRef = new StoreRef(StoreRef.PROTOCOL_WORKSPACE, "SpacesStore");
        serviceRegistry.getSearchService();
        ResultSet rs = serviceRegistry.getSearchService().query(storeRef, SearchService.LANGUAGE_XPATH, "/app:company_home");
        NodeRef parent = null;
        try {
            if (rs.length() == 0) {
                throw new AlfrescoRuntimeException("Didn't find Company Home");
            }
            parent = rs.getNodeRef(0);
        } finally {
            rs.close();
        }
        return parent;
    }
}