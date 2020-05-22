package laboratorio9;

import java.util.Random;
import java.util.Arrays;

public class ArregloBinario
{
    private int[] datos;
    private static Random generador = new Random();

    public ArregloBinario (int tamanio)
    {
        datos = new int[tamanio];

        for (int i=0; i<tamanio; i++)
            datos[i] = 10 + generador.nextInt(90);

        Arrays.sort(datos);
    }

    private int recursive (int elem, int inf, int sup, int med) {
        System.out.print(elementosRestantes(inf,sup));

        for (int i = 0; i<med; i++)
            System.out.print("   ");
        System.out.println(" * ");

        if (inf > sup)
            return -1;

        if (elem == datos[med])
            return med;

        if (elem<datos[med])
            return recursive (elem,inf,med-1,(inf + med) / 2);

    return recursive (elem,med+1,sup,(med + sup + 2) / 2);
    }

    public int busquedaBinaria(int elementoBusqueda)
    {
        int inf = 0;
        int sup = datos.length-1;
        int med = (inf + sup + 1 ) / 2;
        int ubi = -1;

        return recursive (elementoBusqueda,inf,sup,med);
    }

    public String elementosRestantes(int inferior, int superior)
    {
        StringBuilder temporal = new StringBuilder();

        for (int i = 0; i < inferior; i++)
            temporal.append( "   " );

        for (int i = inferior; i <= superior; i++)
            temporal.append( datos[i] + " ");

        temporal.append("\n");
        return temporal.toString();
    }

    public String toString()
    {
        return elementosRestantes(0, datos.length-1);
    }
}