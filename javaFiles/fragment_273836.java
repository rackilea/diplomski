public class AniTimer implements ActionListener {
    Element animating;
    PieceLoc blank;
    int orig_x;
    int orig_y;
    long timeStart;
    int delta;

    public AniTimer(Element e, PieceLoc pl) {
        animating = e;
        blank = pl;
        orig_x = animating.x;
        orig_y = animating.y;
        timeStart = System.currentTimeMillis();
    }

        public void actionPerformed(ActionEvent evt) {
        int dx = (blank.x*piece-orig_x);
        int dy = (blank.y*piece-orig_y);
        int t = 200;
        delta = (int)(System.currentTimeMillis()-timeStart);
        if (delta>t) delta=t;
        animating.x = orig_x + dx*delta/t;
        animating.y = orig_y + dy*delta/t;
        repaint();
        if (delta==t) {
            aniTimer.stop();
            animating.updateCA();
            board.checkCompleted();
        }
    }
}