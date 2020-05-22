public class ResourceLoader {

    private static final String QUESTION_FOLDERNAME = "questions";    

    /**
    * Returns the folder containing all the questions
    *
    */
    public static File getQuestionsFolder(){
        String userDirectory = System.getProperty("user.dir");
        System.out.println(userDirectory+"\\"+QUESTION_FOLDERNAME); 

        return new File(userDirectory+"\\"+QUESTION_FOLDERNAME);
    }

}