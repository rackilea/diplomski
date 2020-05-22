/**
 * This class defines which file types are opened (by default) by the program.
 * This file filter is used to associate a single file type (extension) with the program.
 * You could add more than one file type to the open file dialog using this class by repeatedly
 *    calling addFileFilter.
 */
import java.io.File;
import javax.swing.filechooser.*;

public class OpenFileFilter extends FileFilter {
    public String fileExt = "";
    String txtExt = ".txt";

    public OpenFileFilter() {
        this(".pxml");  //default file type extension.
    }

    public OpenFileFilter(String extension) {
        fileExt = extension;
    }

     @Override public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        return  (f.getName().toLowerCase().endsWith(fileExt)); 
    }

    public String getDescription() {
        if(fileExt.equals(txtExt ))
            return  "Text Files (*" + fileExt + ")";
        else
            return ("Other File");
    }
}