public static void main(String[] args) {


        TextDisplay display = new TextDisplay(10, 5);
        Helper helper = new Helper(display);

        display.setDisplay(new String[] {"OXXXXXXXXO","X        X","X        X","X        X","OXXXXXXXXO"});
        display.addKeyListener(helper);        
        display.setVisible(true);   
    }

    private static class Helper extends KeyAdapter{
        int x = 1;
        int y = 1;
        TextDisplay display = null;

        public Helper(TextDisplay display){
            this.display = display;
            display.setCharAt('P', y, x);
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key != 0) {
                display.setCharAt(' ', y, x);
                switch (key) {
                case KeyEvent.VK_LEFT:
                    if (display.getCharAt(y, x - 1) == ' ') x--;
                    break;
                case KeyEvent.VK_UP:
                    if (display.getCharAt(y - 1, x) == ' ') y--;
                    break;
                case KeyEvent.VK_RIGHT:
                    if (display.getCharAt(y, x + 1) == ' ') x++;
                    break;
                case KeyEvent.VK_DOWN:
                    if (display.getCharAt(y + 1, x) == ' ') y++;
                    break;
                }
                display.setCharAt('P', y, x);
            }
        }
    }