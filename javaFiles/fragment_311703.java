JFileChooser flcFile = new JFileChooser("c:\\");
int result = flcFile.showOpenDialog(null);
if (result == JFileChooser.APPROVE_OPTION) {
    File f = flcFile.getSelectedFile();
    String filename = f.getAbsolutePath();

    try {
        FileReader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        txtPersonal.read(br, null);

        br.close();
        txtPersonal.requestFocus();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}