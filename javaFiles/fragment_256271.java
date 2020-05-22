// Add a 'global' variable within your frame
private static int last_generated_id = 0;

// Add a method that generates and returns a new unique ID
private static synchronized int createUniqueID()
{
    last_generated_id++;
    return (last_generated_id);
}