JFileChooser archivo = new JFileChooser("Seleccione el archivo principal");
int action = archivo.showOpenDialog(null);
File principal = archivo.getSelectedFile();
while (action != JFileChooser.CACNEL_OPTION && !principal.exists()) {
    JOptionPane.showMessageDialog(this, "Not a valid file paht", "error",JOptionPane.ERROR_MESSAGE);
    action = archivo.showOpenDialog(null);
    principal = archivo.getSelectedFile();
}

if (!action == CACNEL_OPTION) {
    // File reference should now be valid, open and read away...
}