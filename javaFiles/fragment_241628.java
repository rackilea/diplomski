public class Main {
public static void main(String[] args) throws IOException
{
    zapisz("BazaDanych.txt");
    Scanner scanner = new Scanner(System.in);
    List<FilmExtended> bazaFilmow = new ArrayList<>();
    //remove index
    while(scanner.nextInt() != 0)
    {
        boolean check = true;
        do
        {
            System.out.println("Podaj tytuł fimu: ");
            String temp = scanner.nextLine();
            if (temp.matches("[a-zA-Z]{2,}"));
            {
                FilmExtended filmExtended = new FilmExtended(); //create new instance
                filmExtended.setTytul(temp);
                bazaFilmow.add(filmExtended); //use add without index or else need to increment your index
                check = false;
            }
        } while (check);

} }