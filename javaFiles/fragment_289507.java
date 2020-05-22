String test = "¬14AAAA3170008@¶%AAAA3170010082¶";
Pattern p = Pattern.compile(
//   | named group definition
//   |         | actual pattern
//   |         | | ¬ + 2 digits or $%
//   |         | |            | 4 hex alnums
//   |         | |            |              | 7 to 10 digits
//   |         | |            |              |        | any 1 or 2 characters    
//   |         | |            |              |        |      | multiple times (2 here)
    "(?<pacote>((¬\\d{2}|[$%])[a-fA-F0-9]{4}\\d{7,10}.{1,2})+)"
);
Matcher m = p.matcher(test);
if (m.find()) {
    System.out.println(m.group("pacote"));
}