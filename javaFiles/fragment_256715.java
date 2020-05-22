timer = new Timer(750, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ballR.setForeground(Color.WHITE);
        ballG.setForeground(Color.WHITE);
        ballB.setForeground(Color.WHITE);
        if (index < sequence.length) {
            String set = sequence[index];
            System.out.println(index + " = " + set);
            for (char c : set.toCharArray()) {
                if ('R' == c) {
                    ballR.setForeground(Color.RED);
                } else if ('G' == c) {
                    ballG.setForeground(Color.GREEN);
                } else if ('B' == c) {
                    ballB.setForeground(Color.BLUE);
                }
            }
        } else {
            timer.stop();
        }
        index++;
    }
});