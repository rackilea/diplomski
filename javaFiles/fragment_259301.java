scanner.nextLine(); // clear the newline after the number of books
while (count < numB)
{
    System.out.println("Enter Book Name:");
    bookName = scanner.nextLine();
    nameArray[count] = bookName;
    count++;
}