popupForTable.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Point mousePoint = new Point();
                        mousePoint = MouseInfo.getPointerInfo().getLocation();

                        int rowAtPoint = table.rowAtPoint(SwingUtilities.convertPoint(popupForTable, new Point(0, 0), table));

                        if (rowAtPoint > -1) {
                            table.setRowSelectionInterval(rowAtPoint, rowAtPoint);
                        }

                    }
                });
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                // TODO Auto-generated method stub

            }

        });

table.setComponentPopupMenu(popupForTable);