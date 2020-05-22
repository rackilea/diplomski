private class ButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        timer.start();
    }
}
Timer timer = new Timer(100, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        icon1.setIcon(icons[ran.nextInt(9)]);
    }
});