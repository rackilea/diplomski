import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultipleCompareMethods
{
    public static void main(String[] args)
    {
        List<Costos> list = new ArrayList<Costos>();

        list.add(new Costos(1,3));
        list.add(new Costos(4,5));
        list.add(new Costos(2,7));

        // Using Method references

        Collections.sort(list, MultipleCompareMethods::compareByReferencia);
        System.out.println("\nOrdenado por Referencia");
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        Collections.sort(list, MultipleCompareMethods::compareByMonto);
        System.out.println("\nOrdenado por Monto");
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));


        // Using Comparator#comparingInt:

        Collections.sort(list, Comparator.comparingInt(c -> c.referencia));
        System.out.println("\nOrdenado por Referencia");
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        Collections.sort(list, Comparator.comparingInt(c -> c.monto));
        System.out.println("\nOrdenado por Monto");
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }

    static int compareByReferencia(Costos c0, Costos c1)
    {
        return Integer.compare(c0.referencia, c1.referencia);
    }
    static int compareByMonto(Costos c0, Costos c1)
    {
        return Integer.compare(c0.monto, c1.monto);
    }

}


class Costos
{
    int referencia;
    int monto;

    Costos(int referencia, int monto)
    {
        this.referencia = referencia;
        this.monto = monto;
    }

    @Override
    public String toString()
    {
        return "COSTOS [referencia=" + referencia + ", monto=" + monto + "]";
    }
}


class Costos
{
    int referencia;
    int monto;

    Costos(int referencia, int monto)
    {
        this.referencia = referencia;
        this.monto = monto;
    }

    @Override
    public String toString()
    {
        return "COSTOS [referencia=" + referencia + ", monto=" + monto + "]";
    }
}