for (int counter = 0; counter < name.length; counter++)
    {
        String n = (name[counter]);
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < counter; i++){
            if (name[i].equals(n)) {
               flag = false;
            }
        }
        if (flag) {
           for (int i = 0; i < name.length; i++){
               if (name[i].equals(n))
                   count++;
           }

           System.out.println(n + " - " + count);
        }
    }