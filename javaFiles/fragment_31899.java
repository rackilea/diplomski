public static void breakTwo(String line)
    {
       String [] numbers = line.split(" ");
       String [] zeros = new String[numbers.length];


       for (int i = 0; i < numbers.length; i++) {
           zeros[i] = "0";
           for (int j = 0; j < ARRSIZE - numbers[i].length() - 1; j++) {
               zeros[i] += "0";
           }
           zeros[i] += numbers[i];
           System.out.println(zeros[i]);
       }
    }