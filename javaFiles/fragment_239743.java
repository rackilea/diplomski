public class ServiceImpl implements Service{

private Foo obj;

@Override
public void insert() {
    . .....
        obj = pool.borrowObject();
    . .....
    return obj;
}

public Foo getFooObj(){
   return obj;
}