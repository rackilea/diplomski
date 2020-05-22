public static String buildStarWarsName(String firstName, String lastName, 
            String maidenName, String town) 
{
    return new StringBuilder(lastName.substring(0, 3)) //
            .append(firstName.substring(0, 2)) //
            .append(" ") // <-- for the space between first and last
            .append(maidenName.substring(0, 2)) //
            .append(town.substring(0, 3)) //
            .toString();
}