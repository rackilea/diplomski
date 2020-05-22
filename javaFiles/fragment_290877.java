public class Window(){

Windows ref = this;
btnDownload.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
                       Engine en = new Engine(ref);
                 }