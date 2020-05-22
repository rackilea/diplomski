//Declarations
        String[] temp;
        String current;

        //Execution
        BufferedReader br = new BufferedReader(new FileReader("d://input.txt"));
        while ((current = br.readLine()) != null) {
            temp = current.split("\\D+"); //Splitting at Non Digits
            for (int i = 0; i < temp.length; i++) {
                if (!temp[i].equalsIgnoreCase("")) {
                    System.out.println(temp[i]);
                }
            }
        }