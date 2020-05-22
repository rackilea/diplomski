Scanner input = new Scanner(System.in);
System.out.print("Enter how student's are in your class: ");
int idStudent = input.nextInt();

int[] id = new int[idStudent];
double[] quiz1 = new double[idStudent];
double[] quiz2 = new double[idStudent];
double[] quiz3 = new double[idStudent];
double[] sum = new double[idStudent];

for (int i = 0; i < idStudent; i++){
  //Now all arrays have size idStudent so 'i' will be in bounds
}