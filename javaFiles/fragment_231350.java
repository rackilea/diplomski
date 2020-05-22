public void keyTyped(KeyEvent e) {
    if(e.getKeyChar() == 'r') {
        new Thread("envolver") { public void run() {
           System.out.println("Run mode");
           _app.envolveCells();
        }).start();
    }
}