public class ServiceImpl implements Service{
private ThreadLocal serviceThreadLocal = new ThreadLocal();

@Override
public void insert() {
    . .....
        obj = pool.borrowObject();
        serviceThreadLocal.set(obj);
    . .....
    return obj;
}

public Foo getFooObj(){
   return serviceThreadLocal .get();
}
}