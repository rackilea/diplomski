public class MoveAnimationHandler implements ActionListener {

    private int usCount = 0;
    private int compCount = 0;
    private Pokemon user;
    private Pokemon computer;

    private int left;
    private int right;

    private int us;
    private JComponent parent;

    private Runnable whenDone;

    public MoveAnimationHandler(JComponent parent, int us, Pokemon user, Pokemon computer, Runnable whenDone) {
        this.parent = parent;
        this.user = user;
        this.computer = computer;
        left = user.leftSide();
        right = computer.rightSide();
        this.us = us;
        this.whenDone = whenDone;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (usCount < user.leftNumFramesMove(us) && compCount < user.rightNumFramesMove(us)) {

            if (usCount < user.leftNumFramesMove(us)) {
                if (us == 0) {
                    left = user.LeftSideMove0(usCount + 1);
                } else if (us == 1) {
                    left = user.LeftSideMove1(usCount + 1);
                } else if (us == 2) {
                    left = user.LeftSideMove2(usCount + 1);
                } else {
                    left = user.LeftSideMove3(usCount + 1);
                }
                usCount += 1;
            }

            if (compCount < user.rightNumFramesMove(us)) {
                if (us == 0) {
                    left = user.LeftSideMove0(usCount);
                } else if (us == 1) {
                    left = user.LeftSideMove1(usCount);
                } else if (us == 2) {
                    left = user.LeftSideMove2(usCount);
                } else {
                    left = user.LeftSideMove3(usCount);
                }

                if (us == 0) {
                    right = user.RightSideMove0(compCount + 1, computer);
                } else if (us == 1) {
                    right = user.RightSideMove1(compCount + 1, computer);
                } else if (us == 2) {
                    right = user.RightSideMove2(compCount + 1, computer);
                } else {
                    right = user.RightSideMove3(compCount, computer);
                }
                compCount += 1;
            }

            parent.repaint();

        } else {

            ((Timer) e.getSource()).stop();
            whenDone.run();

        }
    }
}