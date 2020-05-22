public class Test
{
    public static void main(String... args)
    {
        final JFileChooser chooser = new JFileChooser();
        // This is the flag you need:
        chooser.setMultiSelectionEnabled(true);
        chooser.showSaveDialog(null);

        for (File f : chooser.getSelectedFiles())
        {
            System.out.println(f.getName());
        }
    }
}