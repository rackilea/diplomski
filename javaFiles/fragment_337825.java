public interface A<C extends B> {
     List<C> getBs();
}

public class AImpl implements A<Bimpl>{
     public List<Bimpl> getBs();
}