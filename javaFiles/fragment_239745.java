@Component
public class ServiceImpl implements Service , HasObjectFromPool<Foo> {

    private Foo obj;

    @Override
    @ApplyObjectFromPool
    public void insert() {
        try {
            obj = getObjectFromPool();
            //do something
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Foo getObjectFromPool(){
        return obj;
    }

    @Override
    public void setObjectFromPool(Foo object) {
        this.obj=object;
    }
}