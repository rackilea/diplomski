public void keyPressed(KeyEvent e) {
    int teclaPressionada = e.getKeyCode();

        if (teclaPressionada == KeyEvent.VK_NUMPAD1&& i<9) {
            i++;
            lbNumero.setText("" + i);
            System.out.println(i);
        }

    }