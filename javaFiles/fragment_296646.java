public static void main(String [] args) {
     Scanner input = new Scanner(System.in);
        String[][] name = new String[2][2];
        System.out.println("Enter the name: ");
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {

                name[i][j] = input.next();

            }

        }
        student(name);
    }



public static void student(String[][] arr) {
        int count = 0;
        int v = 0;  
        String[] name2 = new String[arr.length*arr[0].length];
        String temp = "";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j].charAt(0) == 'a') {
                    v = i *+arr[0].length + j;
                    name2[v] = arr[i][j];
                    count++;
                }

            }//inner

        }//outer

        for (int i = 0; i < name2.length; i++) {
            System.out.println(name2[i]);
        }

        System.out.println("printing without nulls");
        //if you don't want null to be printed then do this:
        for (int i = 0; i < name2.length; i++) {
            if(name2[i] != null)
            System.out.println(name2[i]);
        }
    }