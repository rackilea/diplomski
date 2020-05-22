public static void main(String[] args) {

   Scanner input = new Scanner(System.in);
   int counter = input.nextInt();
   Exam[] arr = new Exam[counter];

   for (int i = 0 ; i < counter ; i++) {
     double mark = input.nextDouble();
     double weight = input.nextDouble();
     arr[i] = new Exam(mark, weight);
   }
   System.out.println("The average mark for your "+counter+" assignments/exams is "+ Exam.getAverage(arr));
}