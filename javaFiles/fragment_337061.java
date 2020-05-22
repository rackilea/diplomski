public void componentHidden(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentResized(ComponentEvent e) {
            int width = frame.getWidth();
            button.setFont(new Font("Arial", Font.PLAIN, width / 25));
            frame.getContentPane().revalidate();

    }

    public void componentShown(ComponentEvent e) {

    }