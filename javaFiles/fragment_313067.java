package test;           


    public class StringAppend {         

        public static void main(String[] args) {            

            //Run 1         
            long startTime = System.nanoTime();         
            long startMem = Runtime.getRuntime().freeMemory();          
            StringBuilder sb1 = new StringBuilder("This is a test");            
            for (int i = 1; i <= 1000; i++) {           
                sb1.append("\n");           
            }           
            sb1.append("To Test \"\\n\"");          
        System.out.println("sb1 = " + sb1.toString());          
        long endTime = System.nanoTime();           
        long endMem = Runtime.getRuntime().freeMemory();            

        //Run 2         
        long startTime2 = System.nanoTime();            
        long startMem2 = Runtime.getRuntime().freeMemory();         
        StringBuilder sb2 = new StringBuilder("This is a test");            
        for (int i = 1; i <= 1000; i++) {           
            sb1.append('\n');           
        }           
        sb1.append("To Test '\\n'");            
        long endTime2 = System.nanoTime();          
        long endMem2 = Runtime.getRuntime().freeMemory();           
        System.out.println("Run1: append \"\\n\"execution time [" + (endTime - startTime) + " nanos], Memory " + "[" + (endMem - startMem) + "]");          
        System.out.println("Run2: append '\\n' execution time [" + (endTime2 - startTime2) + " nanos], Memory " + "[" + (endMem2 - startMem2) + "]");           
    }           
}