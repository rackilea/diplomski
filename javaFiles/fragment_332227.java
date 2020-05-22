public class FileExtensionModel extends DefaultComboBoxModel {

    public FileExtensionModel(HashMap select) {

        for(String key : select.keySet()) {
           this.addElement(key);
        }
    }
}