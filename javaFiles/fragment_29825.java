Loan loan = ...
List<String> loanAsList = new ArrayList<>();
for (Field f : loan.getClass().getDeclaredFields()) {
    field.setAccessible(true);
    Object value = field.get(loan); 
    loanAsList.add(value.toString());
}