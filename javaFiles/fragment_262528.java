import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortWithReflection
{
    public static void main(String[] args)
    {
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(new Task("AAA", 222));
        tasks.add(new Task("BBB", 333));
        tasks.add(new Task("CCC", 111));

        System.out.println("By getTitle:");
        tasks.stream()
            .sorted(by("getTitle"))
            .forEach(System.out::println);

        System.out.println("By getDate:");
        tasks.stream()
            .sorted(by("getDate"))
            .forEach(System.out::println);

        System.out.println("By getDate, reversed");
        tasks.stream()
            .sorted(by("getDate", Comparator.naturalOrder().reversed()))
            .forEach(System.out::println);

    }

    private static <T> Comparator<T> by(String methodName)
    {
        return by(methodName, Comparator.naturalOrder());
    }

    private static <T> Comparator<T> by(
        String methodName, Comparator<?> downstream)
    {
        @SuppressWarnings("unchecked")
        Comparator<Object> uncheckedDownstream =
            (Comparator<Object>) downstream;
        return (t0, t1) -> 
        {
            Object r0 = getOptional(t0, methodName);
            Object r1 = getOptional(t1, methodName);
            return uncheckedDownstream.compare(r0, r1);
        };
    }

    private static <T> T getOptional(
        Object instance, String methodName)
    {
        try
        {
            Class<?> type = instance.getClass();
            Method method = type.getDeclaredMethod(methodName);
            Object object = method.invoke(instance);
            @SuppressWarnings("unchecked")
            T result = (T)object;
            return result;
        }
        catch (NoSuchMethodException 
            | SecurityException 
            | IllegalAccessException 
            | IllegalArgumentException 
            | InvocationTargetException
            | ClassCastException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    static class Task
    {
        String title;
        Integer date;

        Task(String title, Integer date)
        {
            this.title = title;
            this.date = date;
        }

        String getTitle()
        {
            return title;
        }

        Integer getDate()
        {
            return date;
        }

        @Override
        public String toString()
        {
            return title + ": " + date;
        }
    }

}