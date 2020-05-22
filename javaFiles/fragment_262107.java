StringBuilder builder = new StringBuilder();

for(int i = 0; i < s.length(); i++)
    for(int j = 0; j < n; j++)
        builder.append(s.charAt(i));

return builder.toString();