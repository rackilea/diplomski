public class DelayedQueue
{
    public static void main(String[] args)
    {
        BlockingQueue<Person> queue = new DelayQueue<Person>();
        Person a = new Person("ram", "chennai", 1);
        Person b = new Person("nick", "manali", 1);
        Person c = new Person("sam", "delhi", 2);
        try
        {
            queue.offer(a);
            queue.offer(b);
            queue.offer(c);
            System.out.println(queue.poll(2, TimeUnit.SECONDS));
        } catch (InterruptedException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
class Person implements Delayed
{
    private String name;
    private String place;
    private long delayTime;

    public Person(String name, String place, long delayTime)
    {
        this.name = name;
        this.place = place;
        this.delayTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(delayTime);
    }

    @Override
    public int compareTo(Delayed person)
    {
        Person b = (Person) person;
        return this.name.compareTo(b.name);
    }

    @Override
    public long getDelay(TimeUnit timeUnit)
    {
        return timeUnit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
}