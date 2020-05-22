enum MyEnum
{
    DOG("woof"),
    CAT("meow");

    String sound;    
    MyEnum(String s) { sound = s; }
}

class MyEnumComparator implements Comparator<MyEnum>
{
    public int compare(MyEnum o1, MyEnum o2)
    {
        return -o1.compareTo(o2); // this flips the order
        return o1.sound.length() - o2.sound.length(); // this compares length
    }
}