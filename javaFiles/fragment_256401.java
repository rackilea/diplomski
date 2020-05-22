myList = new JList ( listData );
JScrollPane listScroller = new JScrollPane () {
    @Override
    public Dimension getPreferredSize () {
        return new Dimension ( DIMENSION, DIMENSION );
    }
};
listScroller.setViewportView ( myList );
contentPane.add ( listScroller );