public class grade {

    public static void main(String[]args) throws FileNotFoundException, UnsupportedEncodingException
    {
        ArrayList<Double> grades=new ArrayList<Double>();
        double grade;
        double total=100;
        int count=0,above=0,below=0;
        String countStr="",aboveStr="",belowStr="";

        grades.add(25.0);
        grades.add(59.2);
        grades.add(75.0);
        grades.add(85.5);
        grades.add(95.0);

        if (grades.size() != 0) {
            double average = (double) total / grades.size();

            System.out.println("\nAverage of grades is " + average);
            for (int i = 0; i < grades.size(); i++) {
                grade = grades.get(i);
                count++;
                countStr += grade + ", "; //All grades
                if (grade > average) {
                    above++;
                    aboveStr += grade + ", ";
                } else {
                    below++;
                    belowStr += grade + ", ";
                }
            }

            System.out.println(above + " grades above average:");
            System.out.println(aboveStr);
            System.out.println(below + " grades below average:");
            System.out.println(belowStr);
            System.out.println("All grades: " + countStr);

            String reversedString=reverseString(countStr);
            System.out.println("Reversed string is "+ reversedString);

        }
    }

    private static String reverseString(String countStr) {
        String[] arr_grades=countStr.split(", ");
        String reversed="";
        for(int i=arr_grades.length-1;i>=0;i--)
        {
            reversed+=arr_grades[i]+", ";
        }
        return reversed;
    }