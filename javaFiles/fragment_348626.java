// Bad:
@Override
public void paintComponent(Graphics g) {
    // paint the ellipse, etc.
}

// Good:
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // paint the ellipse, etc.
}