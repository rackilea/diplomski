public class metodos {

    String link = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg";
    public void alterajlabel(JLabel label) throws IOException {
        label.setIcon(new ImageIcon(link));
    }
}