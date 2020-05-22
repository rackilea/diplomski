class Students
{
int roll;
String name;
int collegecode;
public static void main (String args[])
{
   Students o1= new Students();
   o1.roll =12;
   o1.name ="james";        // This is a bad practice,fields should be private
   o1.collegecode = 7523 ;         
   Students o2 = new Students();
   o2.roll =13;            //  getter, setter methods should be used
   o2.name ="Michael";
   o2.collegecode= 7523;
}

}