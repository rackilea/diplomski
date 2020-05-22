void method(Object o)
{
  method2((List&AutoCloseable)o);
}

<T extends List&AutoCloseable> void method2(T v)
{

}