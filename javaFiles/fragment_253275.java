....
    while (line != null) {
        if(!line.startsWith(",") && !line.isEmpty()){
            array = line.split(",");
            ID = Integer.parseInt(array[0]);
            name = array[1];
            GPA = Double.parseDouble(array[2]);
            double ahead = GPA - 2;
            System.out.println("WIN: " + ID + " | " + " Name: " + name + " |" + " GPA = " + GPA + " | Ahead by " + ahead);
        }
        line = reader.readLine();
    }