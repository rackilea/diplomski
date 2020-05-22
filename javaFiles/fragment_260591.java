import java.util.*; 

public class Total{ 

   static int total; 
   public static void main(String[] args) { 

    int numberArray[] = {100, 200, 300, 400, 500}; 

    List<String> list = new ArrayList<String>(); 
    Scanner input = new Scanner(System.in); 

    do{ 
        System.out.println("Add item? Please enter \"y\" or \"n\""); 
        if (input.next().startsWith("y")){ 
            System.out.println("Enter item number: "); 
            String temp = input.next(); //store the user inputed element
            list.add(temp); //add that element in list
            //System.out.println(input.next()); 

            //Now use the temporary variable in if conditions
            if (temp.contains("1")){ 
                int item1 = numberArray[0]; 
                total = total + item1; 
            } else if(temp.contains("2")){ 
                int item2 = numberArray[1]; 
                total = total + item2; 
            } else if(temp.contains("3")){ 
                int item3 = numberArray[2]; 
                    total = total + item3; 
            } else if(temp.contains("4")){ 
                    int item4 = numberArray[3]; 
                total = total + item4; 
            } else { 
            System.out.println("You have entered invalid item number!"); 
            break; 
            }                
        }else{ 
            System.out.println("You have entered all the item(s)."); 
            break; 
        }        
     } while(true);

        System.out.println("Total is: " + total);
    } 
}