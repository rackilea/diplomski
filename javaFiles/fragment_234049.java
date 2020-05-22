public class metodos {

    String link = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg";
    public void alterajlabel(Tela tela) throws IOException {
        tela.lblImage.setIcon(new ImageIcon(link));
    }
}