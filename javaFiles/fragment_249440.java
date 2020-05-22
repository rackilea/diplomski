@Override
    public void mouseClicked(MouseEvent e) {
        if (!Dragging) {
            /*
            // copy of the tile location assignment code as a reminder
            dx = x * GrassTile.getWidth() / 2
                    - y * GrassTile.getWidth() / 2;
            dy = x * GrassTile.getHeight() / 2
                    + y * GrassTile.getHeight() / 2;
            dx -= ViewLocation.x;
            dy -= ViewLocation.y;
            */
            int pickX = e.getX() + ViewLocation.x;
            int pickY = e.getY() + ViewLocation.y;
            int tileW = GrassTile.getWidth();
            int tileH = GrassTile.getHeight();
            /*
            // assignment code refactored
            x - y = 2 * pickX / tileW;
            x + y = 2 * pickY / tileH;

            // x+y= refactored to y=
            y = (2*pickY / tileH) - x;
            // substitute into x-y + refactor
            2x = (2 * pickX / tileW) + (2 * pickY / tileH);

            // x+y= refactored to x=
            x = (2*pickY / tileH) - y;
            // substitute x-y + refactor
            -2y = (2 * pickX / tileW) - (2 * pickY / tileH);
            2y = (2 * pickY / tileH) - (2 * pickX / tileW);
            */
            int hitx = (int)(((double)pickX / (double)tileW) + ((double)pickY / (double)tileH) - 0.5);
            int hity = (int)(((double)pickY / (double)tileH) - ((double)pickX / (double)tileW) + 0.5);
            Selected.setLocation(hitx, hity);
            repaint();
            //System.out.println("(" + x + "," + y + ")");
        }
    }