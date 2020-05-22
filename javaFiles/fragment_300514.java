public Author(final String line)
{
  final String[] lineContentArray = line.split(";");

  // Note: consider using the standard java field naming convention.
  email = line[0];
  firstName = line[1];
  lastName = line[2];
}