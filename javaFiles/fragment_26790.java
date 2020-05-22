public class Book {  

private static int i = 0;

public Book(){
   i++;
}

@Override
     public String toString() {

          StringBuilder result = new StringBuilder();


          result.append("\n\n-Buch"+ i +": ");
          result.append("\nTitel: " + this.Titel + "§ ");
          result.append("\nAuthor: " + this.Autor + "§ ");

          return result.toString();
     }
}