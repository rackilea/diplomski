JSeparator separator = new JSeparator(){
    @Override
    public Dimension getMaximumSize(){
        return new Dimension(5, 25);
    }
};
separator.setOrientation(JSeparator.VERTICAL);
toolBar.add(separator);