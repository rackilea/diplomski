@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);  // move this here

    if (drawIt) {
        x = 140;  // add these guys
        y = 0;

        for (int i = 1; i <= 50; i++) {
            // .... etc....