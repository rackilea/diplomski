/**
     * paint method
     * 
     * @param g
     *            Graphics context draws the finish line; moves and draws
     *            racers
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the finish line
        finishX = getWidth() - 20;
        g.setColor(Color.blue);
        g.drawLine(finishX, 0, finishX, getHeight());

        if (raceIsOn) {
            /*
             * loop through instance variable ArrayList racerList, which
             * contains Racer object references, calling draw and move for
             * each element.
             */
            for (int i = 0; i < racerList.size(); i++) {
                racerList.get(i).move();
                racerList.get(i).draw(g);
            }

        } else // display racers before race begins
        {

            /*
             * loop through instance variable ArrayList racerList, which
             * contains Racer object references, calling draw for each
             * element.
             */
            for (int i = 0; i < racerList.size(); i++) {
                racerList.get(i).draw(g);
            }

        }
    }