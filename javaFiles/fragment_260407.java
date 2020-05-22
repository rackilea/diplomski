int n = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of employees"));    
int yr = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of years"));

for (int i = 1; i <=n; i ++) {
   double salary = Double.parseDouble(JOptionPane.showInputDialog("Please enter the salary for employee "+i));
   for (int y = 1; y <= yr; y++) {
      double percentage = Double.parseDouble(JOptionPane.showInputDialog("Please enter the percentage for year " +y));
      double perc =(salary * percentage / 100);
      salary = perc + salary;
      JOptionPane.showMessageDialog(null, "Annual salary for employee " +i +" for the year " +y +" is €"+salary);
   } 
}