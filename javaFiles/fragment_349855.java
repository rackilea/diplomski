final int x = e.getX();
final int y = e.getX();
if (e.getClickCount() >= 2) {
    ...
} else {
    Timer timer = new Timer(waitTime, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (doubleClick) {
                /* we are the first click of a double click */
                doubleClick = false;
            } else {
                count++;
                randomBalls.add(new RandomBall(x, y, canvasWidth, canvasHeight));
                /* the second click never happened */
                System.out.println("single click");
            }
        }
    });
    timer.setRepeats(false);
    timer.start();
}