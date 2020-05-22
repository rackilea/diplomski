int num = 123;
char[] chars = Integer.toString(num).toCharArray();
List<String> parts = new Vector<String>();
for (char c : chars)
{
    parts.add(Character.toString(c));
}