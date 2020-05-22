import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class IdeoneWhy
{
    public static class ArrayListTypeToken<T> extends TypeToken<ArrayList<T>>
    {
        ArrayList<T> element = null;
        void setElement(ArrayList<T> element)
        {
            this.element = element;
        }
    }

    public static abstract class TypeToken<T>
    {
        abstract void setElement(T element);
    }

    public static void main(String[] args)
    {
        ArrayListTypeToken<? extends Number> listC = new ArrayListTypeToken<Integer>();
        TypeToken<? extends List<? extends Number>> listD = listC;

        // This is not possible:
        //TypeToken<List<? extends Number>> listE = listC;

        // But let's enforce it with a brutal cast:
        TypeToken<List<? extends Number>> listE = 
            (TypeToken<List<? extends Number>>)(Object)listC;

        // This throws a ClassCastException
        listE.setElement(new LinkedList<Integer>());
    }
}