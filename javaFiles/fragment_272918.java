import java.util.Scanner; 
    import javax.swing.*;
    class Employer{
             public static void main(String [] args)
      {
            String empId; 
            String empName;
            String numOfHrs;
            String hourlyRate;
            Payroll emp1 = new Payroll();
            Object [][]emp = new Object[3][4];
           Scanner sc = new Scanner(System.in);

    for(int i=0;i<emp.length;i++)
      {   // start for loop
            int j=0;  
             emp[i][j]= JOptionPane.showInputDialog(null,"Enter Employer ID");
               if ( (emp[i][j].equals(""))) 
                 {
                   JOptionPane.showMessageDialog( null,"Employee ID Not Correct");
             emp[i][j]= JOptionPane.showInputDialog(null,"Enter Employer ID");       
                }
                ++j;
            emp[i][j] = JOptionPane.showInputDialog(null,"Enter Employer Name");
            if(emp[i][j] == null )
                    {
                JOptionPane.showMessageDialog(null,"Employee Name Cannot Be Empty");
            emp[i][j] = JOptionPane.showInputDialog(null,"Enter Employer Name");
                    }
                ++j;    
            emp[i][j] =  JOptionPane.showInputDialog(null,"Enter Number of Hours Worked on");
            if(emp[i][j] == null )           
            {
            JOptionPane.showMessageDialog(null,"Number of Hour Cannot be empty or more than 8");
            emp[i][j] =  Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Number of Hours Worked on"));
            }
                ++j;
            emp[i][j] = JOptionPane.showInputDialog(null,"Enter Hourly Rate ");             
            if(emp[i][j] == null)
                {
                    JOptionPane.showMessageDialog(null,"Number of Hourly Rate Cannot be empty or Minus Value");
                hourlyRate = JOptionPane.showInputDialog(null,"Enter Hourly Rate ");                

                } 
         emp1 = new Payroll(emp,i ); // this is the 2D array pass to Payroll Class
                   //end inner for loop 
       }//end for loop          
      for(int i=0;i<emp.length;i++)
      {
       System.out.println("Employee Id:" +emp1.getID() );
       System.out.println("Employee Name:" +emp1.getName() );
       System.out.println("Employee Hours:" +emp1.getNumOfHours());
       System.out.println("Employee Total Payment:" +emp1.gettoTotalPay() );
      }

      }
}
    class Payroll
    {
     private String empID;   
     private String empName;
     private int numOfHours;
     private double hourlyRate;
     private double totalPay;

     public Payroll(){}

     public Payroll(Object[][]emp, int scale)
     {

      for(int k=0;k<=scale;k++)
      {
          int l=0;
         this.empID = emp[k][l++].toString();
         this.empName = emp[k][l++].toString();
         this.numOfHours = Integer.parseInt(emp[k][l++].toString()); 
         this.hourlyRate = Float.parseFloat(emp[k][l++].toString());
       }
  }


     public String getID()
     {
     return empID;
     }
     public String getName()
     {
     return empName;
     }
     public int getNumOfHours()
     {
     return numOfHours;
     }
     public double getHourlyRate()
     {
     return hourlyRate;
     }

     public double gettoTotalPay()
     {
     return numOfHours * hourlyRate;
     }

    }