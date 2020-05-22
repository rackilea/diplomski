addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            for (Shape shape : shapeList) {
                Point convertPoint = SwingUtilities.convertPoint(SSCE1.this, e.getPoint(), shape);
                if (shape.contains(convertPoint)) {
                    System.out.println("Hello");
                } else {
                    System.out.println("Goodbye");
                }
            }

        }
    });