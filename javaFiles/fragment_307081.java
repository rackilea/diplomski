public class TestTypes
{
    public static void main(String[] args)
    {
        String[] strings = new String[] {"123", "9999999999999", "50.4", "not a number"};

        for(String str : strings)
        {
        System.out.print("'" + str + "': ");
            for( TypeChecker checker : typesToCheck)
            {
                if(checker.check(str))
                {
                    System.out.print(checker.type.getSimpleName() + " ");
                }
            }
            System.out.println();
        }
    }


    static abstract class TypeChecker
    {
        public final Class type;
        public abstract boolean check(String s);

        TypeChecker(Class type)
        {
            this.type = type;
        }
    }

    // A list of the code for all the checks
    static TypeChecker[] typesToCheck = 
    {
            new TypeChecker(Integer.TYPE) // is Integer
            {
                public boolean check(String s)
                {
                    try{Integer.parseInt(s);}
                    catch(Exception e)
                    {return false;}
                    return true;
                }
            },

            new TypeChecker(Long.TYPE) // is Long
            {
                public boolean check(String s)
                {
                    try{Long.parseLong(s);}
                    catch(Exception e)
                    {return false;}
                    return true;
                }
            }, 

            new TypeChecker(Double.TYPE) // is Double
            {
                public boolean check(String s)
                {
                    try{Double.parseDouble(s);}
                    catch(Exception e)
                    {return false;}
                    return true;
                }
            }, 
    };
}