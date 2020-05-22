public static void main(String[] args) {
    // TODO code application logic here

   int[] age = new int []{21,20,19,18,18,};
   String name [] = {"sofia","maria","john","Petra","mark"};
  int sum = 0;
  int avg;
  int min=age[0];
  int i;
  int counter=0;
  for(i=0;i<age.length;i++){
  if(age[i]<min ) {
     min=age[i];

   }
 }
  for(i=0;i<age.length;i++){
        sum+=age[i];
      }

  avg= sum/age.length;
  System.out.println("the avarage of all Students are :"+avg);
  System.out.println("the minimum age of all Students : "+min);
  for(i=0;i<age.length;i++){
  if (age[i] == min ) {
          System.out.println("the minimum age of all Students  : "+name[i]); 
        }

     }
    }
   }