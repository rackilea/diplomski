public void printOnScreen() 
{ 
    for(Employee e : emp)
    {
        out.println("Name:\t" + e.getName() + "\t\tAge:\t" + e.getAge() + "\n");
    }
}