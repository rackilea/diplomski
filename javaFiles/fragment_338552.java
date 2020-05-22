@SuppressWarnings("unchecked")
public <T>  List<T> getData(Class<T> pClass)
{
   List<T> ob = querywithParams.list();
    return ob;
 }

// example invocation from some other method
    List<Student> ob = getData(Student.class);