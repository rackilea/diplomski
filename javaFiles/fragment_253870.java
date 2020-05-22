new Timer(2000, new ActionListener() { // Create 2 Second Timer
    @Override
    public void actionPerformed(ActionEvent event) {
        if (isModified()) // Any Changes?
            getData(); // Save Data
    }
}).start();