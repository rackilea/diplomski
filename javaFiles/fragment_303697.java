public class RuntimeType
{
    public static void main(String[] args) throws Exception
    {
        String className = "";
        final Class<?> classType = Class.forName(className);
        Task<?> task = TaskFactory.createTask((String)classType.getField("_TYPE").get(null));
        addOperation(task);
    }

    private static <T> void addOperation(Task<T> task)
    {
        task.addOperation(new Operation<T>() 
        { 
            @Override
            public void onNewInput(T input) 
            { 
                System.out.println(input);
            }
        });        
    }
}

class TaskFactory
{
    public static Task<?> createTask(String string)
    {
        return null;
    }
}

class Task<T>
{
    public void addOperation(Operation<T> operation)
    {
    }

}

interface Operation<T>
{
    void onNewInput(T input);
}