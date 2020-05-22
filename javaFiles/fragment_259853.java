String input = "BOY";
char[] chars = input.toCharArray();

StringBuilder output = new StringBuilder();

for (char c : chars)
{
    output.append("&#").append((int) c).append(";");
}