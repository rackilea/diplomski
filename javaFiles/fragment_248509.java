GridLayout experimentLayout = new GridLayout(0,2);//create grid any amount of rows and 2 coloumns

...

compsToExperiment.setLayout(experimentLayout);//add gridlayout to Component/JPanel

compsToExperiment.add(new JButton("Button 1"));
compsToExperiment.add(new JButton("Button 2"));
compsToExperiment.add(new JButton("Button 3"));
compsToExperiment.add(new JButton("Long-Named Button 4"));
compsToExperiment.add(new JButton("5"));