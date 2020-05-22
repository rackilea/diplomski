int count = 0;
    for (Component comp : frame.getContentPane().getComponents()) {
        System.out.println(comp.getBackground());
        if (count == 6) {
            comp.setBackground(Color.GREEN);
        }
        count++;
    }