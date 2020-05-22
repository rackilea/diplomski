public class ViewPool<E extends View> {

ViewFactory<E> factory;

public viewpool( ViewFactory<E> factory ) {
   this.factory = factory;
}

public E employView(){      
    E v;
    if(unemployed.size() > 0){
        v = unemployed.get(0);
        unemployed.remove(v);
    } else {
        v = factory.createView( context );  
    }
    employed.add(v);
    return v;
}