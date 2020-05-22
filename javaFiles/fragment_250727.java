double x = 2.0; //you have your x doublevalue
    String y = "32:2"; //you have your y String value

    String nums = y.replace(":",".");
    double ydouble = Double.parseDouble(nums); // equal 32.2

    double res = ydouble / x; //32.2/2 = 16.1

    for (int i = 0; i < root.lenght; i++) {


        //same thing here, we convert the FA number to a double
        String nums = root[i][2].replace(":",".");
        double rdouble  = Double.parseDouble(nums);


        if(res == rdouble)
            return root[i][2]; //solution found

    }
    return null;