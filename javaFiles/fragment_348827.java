String output = "";
 for(int i=1; i <= 3; i++){
  output += i + ", ";
}
System.out.print(output.substring(0, output.length()-2)); 
//obtains from 1, 2.3 and omit the, end with the length () - 1 as the final //position