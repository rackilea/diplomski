public static void main(String[] args)
{
    //Input file path
    String fileToParse = "C:\\Users\\DELL-PC\\Desktop\\Analysis.txt";
    BufferedReader fileReader = null;

    //Delimiter Declaration
    final String DELIMITER = ",";
    try
    {
        List<String> Student_log= new ArrayList<String>();
        String line = "";
        //Create the file reader
        fileReader = new BufferedReader(new FileReader(fileToParse));

        //Reading the file line by line
        while ((line = fileReader.readLine()) != null) 
        {
            //Get all tokens available in line
            String[] tokens = line.split(DELIMITER);
            student_log = new ArrayList<>();
            for(String token : tokens)
            {
                //Print all tokens
                /// Array Initialization Part 
                Student_log.add(token);
            }
            // calculate average
            int sum = 0;
            for(int i=1; i<student_log.size();i++){            
            sum = sum + Integer.parseInt(student_log.get(i));            
            }

            double average = sum/(student_log.size()-1);
            String result = "fail";
            if(average > 100){
            result = "pass";
            }
            int max = Integer.parseInt(student_log.get(1));
            //Calculate max
            for(int i=1; i<student_log.size(); i++){
            if(max < Integer.parseInt(student_log.get(i)))
            max = Integer.parseInt(student_log.get(i));
            }
            //Calculate min
            int min = Integer.parseInt(student_log.get(1));
            //Calculate max
            for(int i=1; i<student_log.size(); i++){
            if(min > Integer.parseInt(student_log.get(i)))
            min = Integer.parseInt(student_log.get(i));
            }

            System.out.println("Student: " + student_log.get(0));
            System.out.println("Exam_status: " + result);
            System.out.println("Average marks: " +average);
            System.out.println("Maximum marks: " +max);
            System.out.println("Minimum marks: " +min);
            }
            } 
            catch (Exception e) {
         e.printStackTrace();
    } 
    finally
    {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}