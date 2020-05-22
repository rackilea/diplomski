public class Book {

private static int i = 0;
private int i2;

public Book() {
    i2 = i;
    i++;
    // or place 'i2 = i;' here if you want to start with "Book 1 of..."
}

@Override
public String toString() {

    StringBuilder result = new StringBuilder();

    result.append("Book " + i2 + " of " + i + " books in total");

    return result.toString();
}
}