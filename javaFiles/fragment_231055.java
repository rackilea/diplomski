int startvalueBG;
int endvalueBG = 19;
for (startvalueBG = 0; startvalueBG <= endvalueBG; startvalueBG++) {
    bg.add(rb[startvalueBG]);
}

b = new JButton("OK");
b.addActionListener(this);
chooseClubPanel.add(b);

quit = new JButton("Quit");
quit.addActionListener(this);
chooseClubPanel.add(quit);