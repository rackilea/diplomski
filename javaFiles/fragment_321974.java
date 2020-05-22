String[] name = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
int[][] hour = new int[10][3];
String input;

Integer y = null, z, total = 0, pay= 0;
boolean cancel = false;
for (int index = 0; index < name.length; index++) // First array - String names.
{
   for (y = 0; y < hour[index].length; y++) // Second array - name working hours column.
   {
        z = y + 1;
        input = JOptionPane.showInputDialog("Please enter " + name[index] + "’s day " + z + " hours: " );
        pay = Integer.parseInt(input);
        hour[index][y] = pay;
        total += hour[index][y];
   }
   JOptionPane.showMessageDialog(null, name[index] + " total sum of hours is: " + total);
   total = 0;
}
/*for (int x = 0; x < hour.length; x++) {
    System.out.println(name[x] + " : " + Arrays.toString(hour[x]));
}*/
cancel = true;