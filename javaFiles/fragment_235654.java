package vaja13;
import java.util.*;
class Vaja13 
{
    public static void main(String[] args) 
    {
        System.out.print("Vnesi besedilo: ");
        Scanner sc = new Scanner(System.in);
        String besedilo = sc.nextLine();
        char [] tabela  = besedilo.toCharArray();
        int crke = 0, stevke = 0, presledki = 0, i = 0;
        while(i<tabela.length)
        {
           if (Character.isLetter(tabela[i]))
           {
                crke++;
           }
           else if (Character.isDigit(tabela[i]))
            {
                stevke++;
            }
           else if (Character.isWhitespace(tabela[i]))
            {
                presledki++;
            }
           i++;
        }     


        Beseda besedaCrka = new Beseda
        (
                new String[]{"crk","crka","crki","crke"}
        );
        Beseda besedaStevka = new Beseda
        (
                new String []{"stevk","stevka","stevki","stevke"}
        );
        Beseda besedaPresledek = new Beseda 
        (
                new String [] {"presledkov","presledek","presledka","presledki"}
        );
        Beseda glagolBiti = new Beseda
        (
                new String [] {"je","je","sta","so"}
        );
        System.out.format("V besedilu %s %d %s, %d %s in %d %s.\n",
        glagolBiti.vrniObliko(crke),crke,besedaCrka.vrniObliko(crke),
        stevke,besedaStevka.vrniObliko(stevke),
        presledki,besedaPresledek.vrniObliko(presledki));

    }    
}
/**
 * Razred Beseda shranjuje slovnično obliko besede.
 */
class Beseda
{
    String oblikaBesede [];
    Beseda(String oblikaBesede[])
    {
        this.oblikaBesede = oblikaBesede;
    }
    String vrniObliko(int kolicina)
    {
      return  (kolicina < 1 || kolicina > 4? oblikaBesede[0] :
              (kolicina == 2 ? oblikaBesede[2] :
              (kolicina == 3 || kolicina == 4 ? oblikaBesede[3] :
              oblikaBesede[1])));
    }
}