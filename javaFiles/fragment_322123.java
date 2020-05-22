@Override
    public Dimension getMaximumSize() {
        // TODO Auto-generated method stub
        Dimension dim = super.getMaximumSize();
        dim.height = getPreferredSize().height;
        return dim;
    }