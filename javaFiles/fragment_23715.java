List<String> delimiters = new ArrayList<>();
delimiters.add("+");
delimiters.add("-");
delimiters.add("/");
delimiters.add("*");
delimiters.add("%");

List<String> list = new ArrayList<>();

list.add("12");
list.add("510");
list.add("+");
list.add("2");
list.add("*");

List<String> operators = new ArrayList<>();
List<String> operands = new ArrayList<>();

for (String s : list)
{
    if (delimiters.contains(s))
    {
        operators.add(s);
    }
    else
    {
        operands.add(s);
    }
}
System.out.println("Operators: " + operators);
System.out.println("Operands: " + operands);