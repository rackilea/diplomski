Pattern pattern = Pattern.compile("<([^<]+);>");
Matcher matcher = pattern.matcher(out.get(i).toString());
while (matcher.find())
     {
        B2.add(matcher.group(1));
      }