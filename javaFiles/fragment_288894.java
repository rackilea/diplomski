quiz_1 = new JTextField(8);     
    panelForTextFields.add(quiz_1);


    quiz_2 = new JTextField(8);
    panelForTextFields.add(quiz_2);

    quiz_3 = new JTextField(8);
    panelForTextFields.add(quiz_3);

    quiz_4 = new JTextField(8);
    panelForTextFields.add(quiz_4);

    quiz_5 = new JTextField(8);
    panelForTextFields.add(quiz_5);

    quiz_6 = new JTextField(8);
    panelForTextFields.add(quiz_6);

    quiz_7 = new JTextField(8);
    panelForTextFields.add(quiz_7);

    list.add(quiz_1);
    list.add(quiz_2);
    list.add(quiz_3);
    list.add(quiz_4);
    list.add(quiz_5);
    list.add(quiz_6);
    list.add(quiz_7);

    for(int k = 0; k<list.size(); k++){         
        JTextField f  = list.get(k);            
        f.setLocation(0, k*60);
        f.setSize(100, 30);         
    }       

    final int GAP = 40;
    panelForTextFields.setSize(100, 6*( quiz_1.getHeight()  + GAP));