for (int i = 1; i < amountRoles.length; i++) // Iterates through amountRoles
{
    System.out.print("[" + i + "]");
    for(int j = 0; j < amountRoles[i]; j++) // Loop through amountRoles[i]
    {
        System.out.print("" + "*");
    }
    System.out.println(" " + amountRoles[i]);
}