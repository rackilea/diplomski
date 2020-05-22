public class metodos {
    Tela tela;
    String link = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg";

    public metods(Tela tela) {
        this.tela = tela;
    }

    public void alterajlabel() throws IOException {
        tela.lblImage.setIcon(new ImageIcon(link));
    }
}