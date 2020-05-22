import java.util.Random;

public class App {

Random rand = new Random(); //stays same
int num = rand.nextInt(100); //stays same
static long linear = 0;//more optimal to move where initial time is set (t1)

//main where things are run ;)
public static void main(String[] args) {

    //could be placed outside in the class
    int[] array = {1,2,3,4,5};//some array of numbers
    int key = 5; //a key 

    linear = System.currentTimeMillis();//t1 set
    linearSearch(array, 5);//calling of your search function
    linear = System.currentTimeMillis() - linear; //obtaining the difference between the time, and t2 = System.currentTimeMillis()
    //the function started and when it finished
    System.out.println("Linear Search Time: " + linear);//printing out the difference, which is the time taken
    //also note that the number will likely be zero, as this function will run extremely fast for most arrays.

}

//your function
//Linear Search in Unsorted array
private static int linearSearch(int list[],int key)
{

//finds an element in a list
   for(int i=0;i<list.length;i++)
   {
       //if element is found, element is then returned
       if(list[i]==key)
           return i;
   }
   //if element is not found, -1 is returned
   return -1;
}

}