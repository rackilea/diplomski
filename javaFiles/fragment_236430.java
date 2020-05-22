import java.util.Map.Entry;

public class TestMain {

    /**
     * @param args
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(findMainClass());
    }

    public static String findMainClass() throws ClassNotFoundException{
        for (Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread thread = entry.getKey();
            if (thread.getThreadGroup() != null && thread.getThreadGroup().getName().equals("main")) {
                for (StackTraceElement stackTraceElement : entry.getValue()) {
                    if (stackTraceElement.getMethodName().equals("main")) {

                        try {
                            Class<?> c = Class.forName(stackTraceElement.getClassName());
                            Class[] argTypes = new Class[] { String[].class };
                            //This will throw NoSuchMethodException in case of fake main methods
                            c.getDeclaredMethod("main", argTypes);
                            return stackTraceElement.getClassName();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}