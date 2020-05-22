String input = "(2*(sqrt 9))/5";
String[] parts = input.split("(?<=[^\\w\\s])(?=\\w)|(?<=\\w)(?=[^\\w\\s])|(?<=[^\\w\\s])(?=[^\\w\\s])|\\s+");
for (String part : parts) {
    System.out.println(part);
}

(
2
*
(
sqrt
9
)
)
/
5