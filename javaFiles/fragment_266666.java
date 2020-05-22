import java.io.IOException;
import java.util.Properties;
import java.util.Vector;


public class BenchmarkStringStuff {


    public static void main(String[] args) {
        try {
            System.getProperties().store(System.out, "");
        } catch (IOException ioe ) {
            System.out.println("Failed to write properties to STDOUT");
            return;
        }


        BenchmarkStringStuff bss = new BenchmarkStringStuff();
        bss.benchmark(10);
        bss.benchmark(1000);
        bss.benchmark(100000);
        bss.benchmark(1000000);
    }

    public void benchmark(int numTests) 
    {
        Vector<Test> tests = new Vector<Test>();
        tests.add(new OriginalCode());
        tests.add(new TwoSearches());
        tests.add(new SearchOnceAndSubstring());


        Vector<String> testStrings = new Vector<String>();
        // we have a very poor sample, here.  You should test with a better 
        // representation of your expected values
        testStrings.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa[time]aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        Performance overallRuntime = new Performance("overall combined runtime");
        overallRuntime.setCount(numTests * testStrings.size() * tests.size());
        overallRuntime.start();
        for( Test test : tests )
        {
            Performance codePerformance = new Performance(test.getClass().getName());
            codePerformance.setCount(numTests * testStrings.size());
            codePerformance.start();
            for(String testString : testStrings)
            {
                //Performance stringPerformance = new Performance(testString);
                //stringPerformance.setCount(numTests);
                //stringPerformance.start();
                for(int i=0; i<numTests; i++)
                {
                    test.test(testString);
                }
                //stringPerformance.end();
                //System.out.println(stringPerformance.toString());
            }
            codePerformance.end();
            System.out.println(codePerformance.toString());
        }
        overallRuntime.end();
        System.out.println(overallRuntime.toString());
        System.out.println();

    }

    private static String getTime()
    { 
        return "a date"; 
        // static value to avoid any caching behavior - we
        // want to test the algorithm, not the external stuff.
        // you should use your real getTime method to see real numbers
        // for your application
    }

    private static String getName(){ return "a name"; }


    private interface Test {
        public String test(String in);
    }

    public class OriginalCode implements Test {

        public String test(String in)
        {
            in=in.replace("[time]",getTime()); //just some methods returning strings
            in=in.replace("[name]",getName());
            return in;
        }
    }

    public class TwoSearches implements Test {
        public String test(String in)
        {
            if (in.contains("[time]"))
            {
                in=in.replace("[time]",getTime());
            }
            return in;
        }
    }

    public class SearchOnceAndSubstring implements Test {
        public String test(String in)
        {
            String REPLACEME = "[time]";
            int idx = in.indexOf(REPLACEME);
            if( idx == 0 )
            {
                in=getTime() + in.substring(REPLACEME.length());
            }
            else if( idx > 0 )
            {
                in = in.substring(0,idx) + getTime();
                if( idx+REPLACEME.length() < in.length())
                {
                    in += in.substring(idx+REPLACEME.length());
                }
            }
            return in;
        }
    }





    private class Performance
    {
        long start = 0;
        long end = 0;
        String name = null;
        public int count = 0;

        public Performance(String name)
        {
            this.name = name;
        }

        public void start(){ start = System.currentTimeMillis(); }
        public void end() { end   = System.currentTimeMillis(); }
        public void setCount(int count){ this.count = count; } 

        /** be sure to call start & stop first **/
        public long total(){ return end - start; }


        public String toString()
        {
            return count + "cycles    start:"+start+"     end:"+end+"    total:"+total() + "   <---- " + name;
        }
    }
}