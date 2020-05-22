public boolean isSimilar(Color background, Color foreground){
    int r1 = background.getRed();
    int g1 = background.getGreen();
    int b1 = background.getBlue();

    int r2 = foreground.getRed();
    int g2 = foreground.getGreen();
    int b2 = foreground.getBlue();

    if((r2 >= r1+150 || r2 <= r1-150) || (g2 >= g1+150 || g2 <= g1-150) || (b2 >= b1+150 || b2 <= b1-150)){
        return false;             // 150 controls the "sensitivity"

    }
    JOptionPane.showMessageDialog(mainFrame,"Too similar color","Error",JOptionPane.INFORMATION_MESSAGE);
    return true;
}