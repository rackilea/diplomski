table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                clickedRow= table.rowAtPoint(event.getPoint());
                clickedCol= table.columnAtPoint(event.getPoint());
            }
});