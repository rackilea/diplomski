package openuniversity;

public class Main
{

    public static void main(String[] args)
    {
        Main m = new Main();
        char alp = m.methodB();

        System.out.println(alp);
    }

    public static char methodB()
    {

        char [] alphas = {'s','a','u','s','a','g','e'};
        char first = alphas[0];
        for (int i= 1; i < alphas.length; i++) //3
        {
            if (alphas[i] < first) //4
            {
            first = alphas[i];
            }
        }
        return first;
    }
}