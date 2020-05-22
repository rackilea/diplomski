public String showBefore(LocalDate prevDate)
{
    StringBuilder builder = new StringBuilder("");
    Arrays.asList(bank).parallelStream().forEach(account -> {
        if (account != null) {
            LocalDate date = account.getDate();
            if (date != null && date.compareTo(prevDate) == -1 ) {
                builder.append(account.toString()).append("\n");
            }
        }
    });
    return builder.toString();
}