public static void main (String [] args) // no need to declare "throws IOException"
{
    try {
        /* some code here that may throw IOException */
    } catch (IOException ioe) {
        System.err.println("Uhhhh something went wrong!");
        // or some logging can happen
        ioe.printStackTrace();
        System.exit(-6); // a custom error signal can be sent in termination
    }
}