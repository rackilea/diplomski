public String showBefore( Date prevDate)
{
    StringBuilder builder = new StringBuilder("");
    for ( int i = 0; i < size(); i++)
    {
        Account account = bank[i];
        if (account != null) {
            Date date = account.getDate();
            if (date != null && date.compareTo(prevDate) == -1 ) {
                builder.append(account.toString() + "\n")
            }
        }
    }
    return builder.toString();
}