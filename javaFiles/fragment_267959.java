/**
* root for your object hierarchy
*/
public class MyObject
{
    // yadayada
}

/**
* The interface
*/
interface ObjCreator
{
    public MyObject makeObject();
}


/**
* Classes to create specific objects
*/
public class ObjMaker_1
    implements ObjCreator
{
    public MyObject makeObject()
    {
        return new Object1();
    }
}

...

public class ObjMaker_n
    implements ObjCreator
{
    public MyObject makeObject()
    {
        return new Objectn();
    }
}



/** your dictionary */
Map<Integer, ObjCreator> dict = new HashMap<Integer, ObjCreator>();

dict.add(new Integer(1), new ObjMaker_1);
dict.add(new Integer(2), new ObjMaker_2);
...
dict.add(new Integer(n), new ObjMaker_n);