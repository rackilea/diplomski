public static int readInt(String prompt,int type) throws NumberFormatException{
    int data;
    switch(type){
         case 0:
             Scanner input = new Scanner(System.in);
             System.out.print(prompt);
             data = input.nextInt();
             input.close();
             break;
         case 1:
             data=Integer.parseInt(JOptionPane.showInputDialog(prompt));
             break;
         default:
             data=-1;
    }
    return data;
}