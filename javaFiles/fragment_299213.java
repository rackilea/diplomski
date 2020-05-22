public static void main(String[] args){
        FooRepository fooRepository = new FooRepositoryImpl();
        fooRepository.delete(new Foo("Bar"));
}

public class Foo
{
    private String value;

    public Foo(String inValue){
        super();
        value = inValue;
    }
    public String toString(){
        return value;
    }
}

public interface Repository<E>
{
    public void delete(E entity);
}

public interface FooRepository extends Repository<Foo>
{
    //other methods
}

public class AbstractRespository<E> implements Repository<E>
{
    public void delete(E entity){
        System.out.println("Delete-" + entity.toString());
    }
}

public class FooRepositoryImpl extends AbstractRespository<Foo> implements FooRepository
{
     @Override
       public void delete(Foo entity){
          //do something before deleting the entity
            System.out.println("something before");
          super.delete(entity);
       }
}