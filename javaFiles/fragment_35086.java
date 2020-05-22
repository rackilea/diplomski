String[] input = ...;

StringBuilder b = new StringBuilder();
b.append("select * from where id in (");
b.append("?"); // Assume that input contains at least one element
for (int i = 1; i < input.length; i++) b.append(", ?");
b.append(")");

PreparedStatement s = c.prepareStatement(b.toString());

for (int i = 0; i < input.length; i++) s.setString(i + 1, input[i]);