import com.bulenkov.darcula.*;
...
...
BasicLookAndFeel darculaLookAndFeel = new DarculaLaf();
try {
  UIManager.setLookAndFeel(darculaLookAndFeel);
} catch (UnsupportedLookAndFeelException ex) {
  // ups!
}