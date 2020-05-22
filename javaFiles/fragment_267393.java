HashSet<Integer> set = new HashSet<Integer>();

set.add(num);//returns true if the num was not inserted before else return false

if(!set.add(num))//set also has a contains method
{
  System.out.println("You already entered " + num);
}