public static void main(String[] args)
{   
    Tank tank=new Tank();
    tank.fill();
    // check explicitly before terminating
    if (!tank.empty()) 
        System.err.println("Warning: Ending with non-empty tank!");
}