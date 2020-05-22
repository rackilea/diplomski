public abstract class AbstractFoo< F extends AbstractFoo<F> > 
    implements WantToClone<F>{

        public AbstractFoo(){}

        //add common methods here
    }

    public class Foo extends AbstractFoo<Foo>{
        public Foo(){}

        private Foo(int i){
            System.out.println("Foo");
        }

        public Foo instance(){
            return new Foo(1);
        }
    }

    public class Bar extends AbstractFoo<Bar>{
        public Bar(){} 

        private Bar(int i){
            System.out.println("Bar");
        }

        public Bar instance(){
            return new Bar(1);
        }
    }

    public class Nar extends AbstractFoo<Nar>{
        public Nar(){}

        @Override
        public Nar instance() {
            return new Nar();
        } 

    }

    public interface WantToClone< E extends WantToClone<E> >{
        public E instance();
    }


    public class GenericCopyClass< S extends WantToClone<S> >{

        public GenericCopyClass(){}

        public List<S> copyList(List<S> original){
            List<S> temp = new ArrayList<S>();

            for(S item : original){
                temp.add( item.instance() );   
            }
            return original;
        }    
    }