public class Album  {
private String author;
private String name;
private String year;

public Album(String a, String n, String y) { // constructor

author = a;
name = n;
year = y;

}

public String toString()
{

    return  author +","+ name + "," + year;

} 

public int compareTo(Album a) {
    // usually toString should not be used,
    // instead one of the attributes or more in a comparator chain
    return author.compareTo(a.author);

}