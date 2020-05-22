public void run() {
    a = true;

    // **************************************
    // this add ActionListener gets called with every creation 
    // of a new Thread, and then calling .start() on the Thread
    attack1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            healthleft = healthleft - 100;
        }
    });


    // **************************************
    // this code does not belong in an event-driven program
    do {
        healthleftbl.setText(healthleft + "/" + health);
        if (healthleft <= 0) {
            page.show(game, "map");
            break;
        }
        System.out.println(healthleft);
    } while (turn.getState() != null);
}