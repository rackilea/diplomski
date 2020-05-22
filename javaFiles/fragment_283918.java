public abstract class AbstractArrayMyList<E> implements List<E>  {
    protected E[] elementData;
    int size=0;

    protected AbstractArrayMyList(E[] elementData) {
         this.elementData = elementData;
    }

    ....

 }