for ( j=0;j<8;j++)
{
     stemp[j] = new staples();
     System.out.print("Enter your name : ");
     stemp[j].setName(reader.readLine());
     System.out.println("Enter your age : "); 
     stemp[j].setAge(Integer.parseInt(reader.readLine()));
}