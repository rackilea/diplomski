public class Test { 
    public static void main(String[] args) { 

        Random rnd=new Random();

        ArrayList<QAndA> array = new ArrayList<QAndA>();

        array.add(new QAndA("Question 1",true));
        array.add(new QAndA("Question 2",true));


        while (array.isEmpty()==false){
            int index=rnd.nextInt(array.size());

            QAndA question=array.get(index);
            array.remove(index);

            //do whatever with the question
        }


    }

}