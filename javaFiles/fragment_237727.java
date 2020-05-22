import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class ImagesLastModified {

    public static void main(String[] args) {
        File f = new File(System.getProperty("user.home"));

        final File[] files = f.listFiles(new ImageFileNameFilter());
        Arrays.sort(files, new FileDateComparator());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JPanel gui = new JPanel(new BorderLayout());

                JLabel l = new JLabel("Images: " + files.length);
                gui.add(l, BorderLayout.PAGE_START);

                JList<File> list = new JList<File>(files);
                list.setCellRenderer(new FileListCellRenderer());
                gui.add(new JScrollPane(list));

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}


class FileListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);

        if (c instanceof JLabel && value instanceof File) {
            JLabel l = (JLabel)c;
            File f = (File)value;
            l.setText(new Date(f.lastModified()) + " " + f.getName());
        }

        return c;
    }
}

class ImageFileNameFilter implements FilenameFilter {
    String[] suffixes = ImageIO.getReaderFileSuffixes();

    @Override
    public boolean accept(File dir, String name) {
        String s = name.toLowerCase();
        for (String suffix : suffixes) {
            if (s.endsWith(suffix.toLowerCase())) return true;
        }
        return false;
    }
}


class FileDateComparator  implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof File) || !(o2 instanceof File)) {
            throw new IllegalArgumentException("Both objects must be files!");
        }
        File f1 = (File)o1;
        File f2 = (File)o2;
        int i = (f1.lastModified()>f2.lastModified() ? -1 : 1);
        return i;
    }
}