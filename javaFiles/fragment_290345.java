ComboBox[] comoboboxes = new ComboBox[8];
    comoboboxes[0] = d1;
    comoboboxes[1] = d2;
    comoboboxes[2] = d3;
    comoboboxes[3] = d4;
    comoboboxes[4] = d5;
    comoboboxes[5] = d6;
    comoboboxes[6] = d7;
    comoboboxes[7] = d8;

    for (int x = 0; x < 8; x++) {
        String a = t1.getText();
        int i = AssignRollno();
        int j = comboboxes[x].getSelectedIndex();
        if (j == 0) {
            String str1 = "insert into dx values(" + i + ",'" + a + "')";
            execute(str1);
            String str2 = "insert into t" + i + "1" + " values(0)";
            execute(str2);
        } else {
            String str3 = "insert into t" + i + "1 values(" + j + ")";
            execute(str3);
        }
    }