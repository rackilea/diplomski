static public Matriz[] create()
{
    ...
    Matriz[] m = new Matriz[2];
    m[0] = new Matriz(someValue, anotherValue);
    m[1] = new Matriz(someValue, anotherValue); 
    ...
    return m;
}