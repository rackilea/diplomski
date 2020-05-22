public class App
{

    public static void main(String[] args) 
    {
        // Array containing your enum constants
        String json = "[\"ONE\",\"TWO\",\"THREE\"]";

        Type t = new TypeToken<Collection<MyEnum>>(){}.getType();
        Collection<MyEnum> c = new Gson().fromJson(json, t);

        for (MyEnum me : c)
        {
            System.out.println(me);
            switch(me)
            {
                case ONE:
                    System.out.println("This is equal to MyEnum.ONE");
                    break;
                case TWO:
                    System.out.println("This is equal to MyEnum.TWO");
                    break;
                case THREE:
                    System.out.println("This is equal to MyEnum.THREE");
                    break;
            }
            System.out.println(me.getDouble());

        }
    }    
}