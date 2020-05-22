public class A
{

    public String att;    

    public static abstract class Builder<T extends A, U extends Builder<T, U>>
    {

        public T a;

        public abstract T build();

        public U setAtt(String a)
        {
            this.a.att = a;
            return getBuilder();
        }

        public abstract U getBuilder();        


    }        
}