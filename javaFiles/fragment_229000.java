import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class XSTReamTest {
    /*
 * ExpertService.class
 */
    public static void main(String args[]) throws Exception {
        XSTReamTest tst = new XSTReamTest();
        tst.createXmlExport();
    }

    public File createXmlExport() throws Exception {
        XStream xstream = new XStream();
        File xmlExportFile = null;
        BufferedOutputStream outputStream = null;
        OutputStreamWriter streamWriter = null;

        try {
            xmlExportFile = new File("easylearncards1_exportRequest_.xml");
            System.out.println("Path = " + xmlExportFile.getAbsolutePath());

            outputStream = new BufferedOutputStream(new FileOutputStream(xmlExportFile));
            streamWriter = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
            exportCategories(xstream, streamWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                streamWriter.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return xmlExportFile;
    }

    private void exportCategories(XStream xstream, OutputStreamWriter streamWriter) {
        // register alias
        xstream.alias("category", ServerCategory.class);

        // register converter
        xstream.registerConverter(new ServerCategoryConverter());

        // get all categories
        List<ServerCategory> categoryList = new ArrayList<ServerCategory>();

        ServerCategory root = new ServerCategory("1", "One", "One", "V1", null);
        ServerCategory child1 = new ServerCategory("2", "Two", "Two", "V1", new ServerCategory[]{root});
        ServerCategory child2 = new ServerCategory("3", "Three", "Three", "V1", new ServerCategory[]{root});
        ServerCategory child3 = new ServerCategory("4", "Four", "Four", "V1", new ServerCategory[]{child1, child2});

        categoryList.add(root);
        categoryList.add(child1);
        categoryList.add(child2);
        categoryList.add(child3);

        // convert all categories
//        for (ServerCategory category : categoryList) {
//            xstream.toXML(category, streamWriter);
//        }
        xstream.toXML(categoryList, streamWriter);
    }

    static class ServerCategory {
        String id;
        String name;
        String description;
        String syncVersion;
        ServerCategory parents[];

        ServerCategory(String id, String name, String description, String syncVersion, ServerCategory[] parents) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.syncVersion = syncVersion;
            this.parents = parents;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSyncVersion() {
            return syncVersion;
        }

        public void setSyncVersion(String syncVersion) {
            this.syncVersion = syncVersion;
        }

        public ServerCategory[] getParents() {
            return parents;
        }

        public void setParents(ServerCategory[] parents) {
            this.parents = parents;
        }
    }
/*
 * ServerCategoryConverter.class
 */

    static class ServerCategoryConverter implements Converter {

        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {

            ServerCategory category = (ServerCategory) value;

            writer.startNode("id");
            writer.setValue(category.getId().toString());
            writer.endNode();

            writer.startNode("name");
            writer.setValue(category.getName());
            writer.endNode();

            writer.startNode("description");
            writer.setValue(category.getDescription());
            writer.endNode();

            writer.startNode("syncversion");
            writer.setValue(category.getSyncVersion().toString());
            writer.endNode();

            writer.startNode("parents");
            if (category.getParents() != null) {
                for (ServerCategory parent : category.getParents()) {
                    writer.startNode("parent");
                    writer.setValue(parent.getId().toString());
                    writer.endNode();

                }
            }
            writer.endNode();

        }

        public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader hierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext unmarshallingContext) {
            return null;
        }

        public boolean canConvert(Class foo) {
            if (foo.getName().equals("java.util.ArrayList")) {
                return false;
            }
            return true;
        }

    }
}