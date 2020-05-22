Timer timer = new Timer(1000, new ActionListener() {
    public void actionPerformed(ActionEvent a)
    {
        System.out.println("Timer went off!");
    }
});

// Repeat every second
timer.start();