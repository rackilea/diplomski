@Override
public int getBaseline(int w, int h) {
    // helps with simple managers like FlowLayout
    // detoriates with powerful managers like GridBag or Mig
    doLayout();
    Dimension size = textField.getPreferredSize();
    return textField.getY() + textField.getBaseline(size.width, size.height);
}