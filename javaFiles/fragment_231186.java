@Override
    public void paint(Graphics g)
    {
        super.paint(g); // added this

        g.setColor(new Color(0x00f0f0f0));
//      g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(rule, alpha));
        g.fillRect(mouseRect.x, mouseRect.y, mouseRect.width, mouseRect.height);
        g.drawRect(mouseRect.x, mouseRect.y, mouseRect.width, mouseRect.height);
    }