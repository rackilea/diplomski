JPanel panel = new JPanel();
panel.add(play);
panel.add(stopeject);
panel.add(rewind);
panel.add(fastforward);
panel.add(pause);

//right now panel is the parent component of play, stop, eject

JPanel panel2 = new JPanel();
panel2.add(play); //play is now owned by panel2, not panel
panel2.add(stopeject); //stopeject is now owned by panel2, not panel
panel2.add(new JButton("Rewind")); // this is how you should do this