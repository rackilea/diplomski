scroll.getViewport().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (scroll.getVerticalScrollBar().isVisible())
                      scroll.setPreferredSize(480, 200);
                }
            }
});