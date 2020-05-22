class ParentClass
{
    protected final static Set THE_SET;

    static {
        THE_SET = new HashSet();
        THE_SET.add("one");
        THE_SET.add("two");
        THE_SET.add("three");
    }
}


class SubClass extends ParentClass
{
    protected final static Set THE_SECOND_SET;

    static {
        THE_SECOND_SET = new HashSet();
        THE_SECOND_SET.add("four");
        THE_SECOND_SET.add("five");
        THE_SECOND_SET.add("six");
        union(ParentClass.THE_SET); /* [1] */
    }
}