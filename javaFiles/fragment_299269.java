StringBuilder s = 
    p.stream()
     .filter( p -> p.lastName.equals("kent"))
     .map(p -> p.lastName)
     .collect(() -> new StringBuilder(),
              (stringBuilder, string) -> stringBuilder.append(string),
              (stringBuilder1, stringBuilder2) -> stringBuilder1.append(stringBuilder2));