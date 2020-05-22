public static void main(String[] arg) throws IOException {
    double[][] grades = null;
    double[][] gradelist = Grade(grades);

    for(int i=0; i < gradelist.length; i++) {
        for(int j=0; j < gradelist[i].length; j++) {
            System.out.println(gradelist[i][j]);
        }
    }
}

public static double[][]Grade(double[][]grade) {
    Scanner in  = null;
    try {
        in = new Scanner(new FileInputStream("input.txt"));         
        in.nextLine();

          int rows = 6;
          int columns = 12;

          grade = new double[rows][columns];

          while(in.hasNextLine())  {
             for (int i=0; i< grade.length; i++) {
                String[] line = in.nextLine().trim().split(" ");
                for (int j = 1; j < line.length; j++) {
                   grade[i][j] = Double.parseDouble((line[j]));
                }
             }
          }
    }
    catch(Exception e) {
    }

    return grade;
}