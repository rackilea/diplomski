public class SO{
public static void main(String[] args) throws IOException{
    JFrame frame = new JFrame();
    JTextPane pane = new JTextPane();
    frame.add(pane);
    BufferedReader br = new BufferedReader(new FileReader("D:\\Users\\user2777005\\Desktop\\test.txt"));
    String everything = "";
    try {
        StringBuilder sbuild = new StringBuilder();
        String line = br.readLine();
            while (line != null) {
                sbuild.append(line);
                sbuild.append('\n');
                line = br.readLine();
            }
            everything = sbuild.toString();
    } catch (FileNotFoundException e) {
                e.printStackTrace();
    } finally {
        br.close();
    }
    pane.setFont(new Font("Segoe Print", Font.BOLD, 12));
    pane.setText(everything);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
}
}