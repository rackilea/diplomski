for (int i =0; i <answers.length; i++)
   {

       System.out.println("Enter the answer to be graded : ");
       int  toGrade = scan.nextInt();

       if(i % 2 == 0 && toGrade == answers[i]){   
          count++ ;

       }


   }