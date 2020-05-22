tab1 = new JPanel();
OfficeAreaCalculator OAC = new OfficeAreaCalculator();
tab1.add(OAC);

tab2 = new JPanel();
DayGUI Day = new DayGUI();
tab1.add(Day);

ourTabbedPane.addTab("Office Area Calculator", tab1);
ourTabbedPane.addTab("DayGUI", tab2);