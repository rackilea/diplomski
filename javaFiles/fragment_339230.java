public void keyPressed(KeyEvent kevt) {
    if (kevt.getKeyChar() == 'l') {
        if (kevt.isAltDown()) {
            f.setAlwaysOnTop(false);
            f.setVisible(false);
            try {
                Thread.sleep(5 * 1000);
                visible();
                Thread.sleep(5 * 1000);
                //Process process = Runtime.getRuntime().exec("saving.bat");
                Thread.sleep(500);
                f.setAlwaysOnTop(true);
                f.setVisible(true);
                Process process2 = Runtime.getRuntime().exec("kopia.bat");
            } catch (IOException | InterruptedException e) {
            }
        }
    }