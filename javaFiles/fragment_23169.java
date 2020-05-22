public class Test { 
    public static void main(String[] args) { 

        Random rnd=new Random();
        ArrayList<String> questions = new ArrayList<String>();
        ArrayList<Boolean> answers = new ArrayList<Boolean>();

        questions.add("Question 1");
        answers.add(true);

        questions.add("Question 2");
        answers.add(false);

        while (array.isEmpty()==false){
            int index=rnd.nextInt(questions.size());

            String question=questions.get(index);
            boolean answer=answers.get(index);

            questions.remove(index);
            answer.remove(index);

            //do whatever with the question
        }


    }

}