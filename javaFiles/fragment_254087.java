public void chartMouseMoved(final ChartMouseEvent event) {
            if (event.getEntity() instanceof XYItemEntity) {
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                clickedSimulationItem = (XYItemEntity) event.getEntity();
            } else if (event.getEntity() instanceof PlotEntity) {
                handleMouseMoveOnPlot(event);
            } else {
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                clickedSimulationItem = null;
            }
        }


private void addMouseListener() {
    panel.addMouseListener(new MouseListener() {
        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                if (clickedSimulationItem != null) {

                        panel.getPopupMenu().add(new JMenuItem("denem"));
                        /** update pop up */
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
        }
    });
}