String[] operators = new String[equation.length/2];
String[] fractions = new String[operators.length+1];
for (int i = 0; i < equation.length; i+=2)
{
    fractions[i] = equation[i];
    operators[i] = equation[i+1];
}