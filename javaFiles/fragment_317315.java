jLabel1.setFont(new Font("monospace", Font.PLAIN, 12));
    FontMetrics fm = jLabel1.getFontMetrics(jLabel1.getFont());
    int w = fm.stringWidth("0000");
    int h = fm.getHeight();
    Dimension size = new Dimension(w, h);
    jLabel1.setMinimumSize(size);
    jLabel1.setPreferredSize(size);