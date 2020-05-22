jList.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            JList l = (JList)e.getSource();
            ListModel m = l.getModel();
            int index = l.locationToIndex(e.getPoint());
            if( index>-1 ) {
                l.setToolTipText(m.getElementAt(index).toString());
            }
        }
    });