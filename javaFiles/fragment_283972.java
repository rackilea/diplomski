catch(Exception e)
{
    System.out.println("SOMETHING WENT WRONG!");
    System.out.println(e.getMessage());
    throw new PelopsException(e.getMessage());
}