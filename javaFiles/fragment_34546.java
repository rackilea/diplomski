public class WriteArea extends JPanel implements KeyListener{
//...
     textArea.addKeyListener(this);
//...
}

@Override
public void keyPressed(KeyEvent arg0) {
    if (this.getFont().getFontName() != buttonPanel.getCurrentFont()) {
    textArea.setFont(new Font(buttonPanel.getCurrentFont(), Font.ITALIC, 12));
    }
}