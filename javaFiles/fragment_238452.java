public class Animal {
    static String call = "Animals make noises, but do not have a default noise, so we're just printing this instead.";
    public void sound()
    {
        System.out.println(getSound ());
    }

    public String getSound ()
    {
        return call;
    }
}

class Cow extends Animal {
    @Override
    public String getSound ()
    {
        return "moo";
    }
}