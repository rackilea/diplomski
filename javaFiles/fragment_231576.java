public interface MapSite<T>{
  T cloneIt();
}

public abstract class AbstractMapSite<T> implements MapSite<T>{
  ...
}


public class Wall extends AbstractMapSite<Wall>{
   public Wall cloneIt(){
       ...
   }
}