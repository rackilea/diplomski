public static void main(String[] args) {
         String Name = new String();
         int quiz1;
         int quiz2;
         int quiz3;
         int quiz4;
         int mid1;
         int mid2;
         int Final;
         double grade;

         Scanner getScores = new Scanner(System.in);
         System.out.println("Please enter name with test scores with a space in between each, in the order of "
                 + "Quiz 1 Quiz 2 Quiz 3 Quiz 4\n Midterm 1 Midterm 2 and Final\n");//Shows the format needed
        String[] inputs = getScores.readLine ().Split (" ");
        Name = inputs[0]
        quiz1 = inputs[1]
        quiz2 = inputs[2]
        quiz3 = inputs[3]
        quiz4 = inputs[4]
        mid1 = inputs[5]
        mid2 = inputs[6]
        Final = inputs[7]

         grade =( quiz1  *   .10 +   quiz2   *   .10 +   quiz3   *   .10 +   quiz4   *   .10 
                +    mid1    *   .20 +   mid2    *   .15 +   Final * .25);
         System.out.print(Name);
         if  (grade >= 90)
             System.out.println("A");
         if (grade >= 80 && grade< 90)
             System.out.println("B");
         if (grade >= 70 && grade< 80)
             System.out.println("C");
         if (grade >= 60 && grade< 70)
             System.out.println("D");
         if  (grade <= 59)
             System.out.println("F");

 getScores.close();

     }