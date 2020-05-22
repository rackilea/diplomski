import java.io.IOException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.tools.ant.BuildException;

public class FilePronouncer extends Task {

    private String filePath    = null;
    private String retProperty = null;

    public String getFilePath() {  
        return filePath;  
    }  

    public void setFilePath(String filePath) {  
        this.filePath = filePath;
    }

    public String getRetProperty() {  
        return retProperty;  
    }  

    public void setRetProperty(String property) {  
        this.retProperty = property;  
    }

    public void execute() {
        try {
        Path path = FileSystems.getDefault().getPath(filePath);
        boolean fileExists           = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        Boolean isSymlink            = null;
        Boolean filePointedToExists  = null;
        if (fileExists) {
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            isSymlink = attrs.isSymbolicLink();
            if (isSymlink)
                filePointedToExists = Files.exists(path);
        }
        Project project = getProject();  
        String rv = null;
        if (!fileExists)
            rv = "not-exists";
        else {
            if (!isSymlink)
                rv = "regular-file";
            else {
                if (filePointedToExists)
                    rv = "symlink-ok";
                else
                    rv = "symlink-dangling";
            }
        }
        project.setProperty(retProperty, rv);
        } catch (IOException e) {
            throw new BuildException(e);
        }
    }
}