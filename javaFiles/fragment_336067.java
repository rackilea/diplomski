String filePath = fc.getSelectedFile().getAbsolutePath();
final String ext = ".txt";
String filePathWithoutExt;

if (filePath.endsWith(ext)) {
    filePathWithoutExt = filePath.substring(0, filePath.length() - ext.length());
} else {
    filePathWithoutExt = filePath;
}

File test = new File(filePathWithoutExt + ext);
File temp = new File(filePathWithoutExt + ext);

int count = 0;

while (temp.exists()) {
    count++;
    temp = new File(filePathWithoutExt + "(" + count + ")" + ext);
}

if (!test.equals(temp)) {
    JOptionPane.showMessageDialog(null,
        "File already exists. So it's saved with (" + count + ") at the end.");
}