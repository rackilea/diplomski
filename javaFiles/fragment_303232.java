public void setScale(double p_newScale) {
    m_scale = p_newScale;
    int width = (int) (getWidth() * m_scale);
    int height = (int) (getHeight() * m_scale);
    setPreferredSize(new Dimension(width, height));
    repaint();
    revalidate();
}