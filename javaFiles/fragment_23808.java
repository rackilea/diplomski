public class ColorLabel extends JLabel {
  public ColorLabel(String text, Color bg) {
    super(text); // **this** super makes sense
    setBackground(bg);
    setOpaque(true);
  }

  // + overloads for other constructors that accept Icon or text and Icon, or 
  // text, Icon and position,....
}