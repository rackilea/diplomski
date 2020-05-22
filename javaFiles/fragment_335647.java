import java.io.File;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyFileChooser extends JFileChooser {

public MyFileChooser(String path, String defName) {
    super(path);
    FileFilter txtType = new FileNameExtensionFilter("Text File (.txt)", "txt");
    FileFilter htmlType = new FileNameExtensionFilter("HTML File (.HTML)", "HTML");
    this.addChoosableFileFilter(txtType);
    this.addChoosableFileFilter(htmlType);
    this.setSelectedFile(new File(defName));
    Action details = this.getActionMap().get("viewTypeDetails");
    details.actionPerformed(null);
}

public String getFullName() {
    String[] temp;
    String extens, temp2, temp3;

    temp3 = this.getSelectedFile().getName();
    try {
        temp = this.getFileFilter().getDescription().split("[\\(||\\)]");

        if (temp3.endsWith(temp[1])) {
            return temp3;
        }else{
            return temp3 + temp[1];
        }
    }catch (Exception e){

        try {
            temp2 = this.getSelectedFile().getName();
            extens = temp2.substring(temp2.lastIndexOf('.')).trim();

            return temp3;
        }catch (Exception ee) {
            return temp3 + ".txt";
        }               
    }
}


public String getFolderPath() {
    String inputName = this.getSelectedFile().getName();
    String fullPath = this.getSelectedFile().getPath();
    String result = fullPath.replaceAll(""+ inputName + "$", "");

    return result;
}

}