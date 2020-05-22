public void printOnScreen() 
{ 
    for(Employee e : emp)
    {
        e = new Employee(); // <<< THIS IS WRONG, AS e IS ALREADY SET BY LOOP!!
        out.println("Name:\t" + e.getName() + "\t\tAge:\t" + e.getAge() + "\n");
    }
}