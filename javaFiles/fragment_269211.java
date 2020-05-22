String str = "hello   <>@<>i try!!  <>@<>   every thing  <>@<><>@<>man <>@<>1234567";
String[] toks = str.split( "(\\s*<>@<>\\s*)+" );
for (String tok: toks)
    System.out.printf(">>> [%s]%n", tok);

str = "hello<>@<>i try!!<>@<>every thing<>@<><>@<>man<>@<>1234567";
toks = str.split( "(\\s*<>@<>\\s*)+" );
for (String tok: toks)
    System.out.printf(">>> [%s]%n", tok);