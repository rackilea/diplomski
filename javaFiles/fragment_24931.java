import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFileChooser {
    private int result;
    private File filename;
    private File subFile;
    private FileNameExtensionFilter filter;

    public FileChooser() {
        filename = new File(System.getProperty("user.home"));
        filter = new FileNameExtensionFilter("Subtitle Files (*.srt)", "srt");
        this.setDialogTitle("Select a file");
        this.setCurrentDirectory(filename);       
        this.setFileFilter(filter);
        result = this.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) 
            subFile = this.getSelectedFile();   
        this.setVisible(true);
    }

    public File getFile() {
        return subFile;
    }

}