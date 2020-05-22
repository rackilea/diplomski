CDatabase recBox;

    for (int i = 0; i < 9; i++) {
        recBox = new CDatabase();
        // populating customized ArrayList
        recBox.var1 = i * 1.1;
        recBox.var2 = i * 11.;
        box.add(recBox);

        // populating standard ArrayList   
        var1.add(Double.toString(i * 1.1));
        var2.add(Double.toString(i * 11.));
    }