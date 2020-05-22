class myClass
{
    static int s_int;

    static
    {
       try {
          s_int = getInteger();
       } catch (myClassException e) {
          // Handle it here.
       }
    }

    static getInteger() throws myClassException
    {
        ...