final JDialog myModalDialog = ....;
final JDialog mySecondDialog = ....;
int timerDelay = 3000;
Timer timer = new Timer(timerDelay, e -> {
    myModalDialog.dispose();
    mySecondDialog.setVisible(true);
});
timer.setRepeats(false);
timer.start();
myModalDialog.setVisible(true);