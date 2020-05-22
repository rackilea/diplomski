public static void main(String [] args)
{
    try(MyDbWrapper wrapper = new MyDbWrapper())
    {
        // Execute other task with usage of the database wrapper
    }
}