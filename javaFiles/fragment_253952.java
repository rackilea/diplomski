public static void main(String[] args)
{

    Scanner input= new Scanner(System.in);
    System.out.print("Enter number of Employees: ");
    int numberOfEmp= input.nextInt();

    int[] arrayList= new int[numberOfEmp];

    for (int i = 0; i < arrayList.length; i++){

    System.out.print("Enter Employee Name: ");
    String empName= input.next();

    System.out.print("Enter hourly rate: ");
    int rate= input.nextInt();

    System.out.print("Enter hours worked: ");  
    int hours=input.nextInt();

    Salary sal=new Salary();
    sal.CalculateGaji(hours,rate,empName);




    }
    }
    }



class Salary {

    public void CalculateGaji(int hours,int rate,String empName){

   if (hours >=40)
   {
   double regPay=  hours * rate;
   double otPay = (hours-40) *(rate*1.5);
   double totalPay= regPay + otPay;
   System.out.print("\nEmployee name: " + empName+"\n Regular pay: " + regPay +"\n Overtime pay: " + otPay+ "\n Total pay: " + totalPay+ "\n"+ "\n");
  }

    else
   {
   double regPay=  hours * rate;
   double otPay =0;
   double totalPay= regPay + otPay;
   System.out.print("\nEmployee name: " + empName+ "\n Regular pay: " + regPay +"\n Overtime pay: " + otPay+ "\n Total pay: " + totalPay+ "\n"+ "\n");
  }

 }
}