public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, null);
        g.setColor(Color.BLACK);

        drawLabels(g, labelList);

    }

public void drawLabels(Graphics g, LinkedList<Label> labelList) {

        for (Label l : labelList) {
            // drawString(l.getContent(), l.getX(), l.getY());
        }

    }