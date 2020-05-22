package net.pms.plugin.webservice.filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import net.pms.plugin.webservice.ServiceBase;

@WebService(serviceName = "FileSystem", targetNamespace = "http://ps3mediaserver.org/filesystem")
public class FileSystemWebService extends ServiceBase {

    @WebMethod()
    public List<String> getRoots() {
        List<String> roots = new ArrayList<String>();
        for(File child : File.listRoots()) {
            roots.add(child.getAbsolutePath());
        }
        return roots;
    }

    @WebMethod()
    public List<String> getChildFolders(@WebParam(name="folderPath") String folderPath) throws FileNotFoundException {
        List<String> children = new ArrayList<String>();
        File d = new File(folderPath);
        if(d.isDirectory()) {
            for(File child : d.listFiles()) {
                if(child.isDirectory() && !child.isHidden()) {
                    children.add(child.getAbsolutePath());
                }
            }
        } else {
            throw new FileNotFoundException();
        }
        return children;
    }
}