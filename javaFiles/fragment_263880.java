import javax.imageio.*;

...

JFileChooser fileOpen = new JFileChooser();

// Get array of available formats
String[] suffices = ImageIO.getReaderFileSuffixes();

// Add a file filter for each one
for (int i = 0; i < suffices.length; i++) {
    FileFilter filter = new FileNameExtensionFilter(suffices[i] + " files", suffices[i]);
    fileOpen.addChoosableFileFilter(filter);
}

// Show dialog
int ret = fileOpen.showDialog(null, "Open file");