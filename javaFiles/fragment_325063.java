String input = "605,2A,401-2A,32C,21F,201A,605A,401-1A,200-2E,462A,462,583-58D,200,462-1A,583/58E,583-57D, 542,2B, 1, 542/2E, 801, 802, 803, 605B, 32D, 3, 603, 4, 6, 5, 60, 201C, 542/2D,40,20,2C,800,800-1,50,200-2C,21C,800A,200A,571-573L,51/2,470/1,51/1,571-573K,454-1,444-446,571-573M";
List<String> items = Arrays.asList(input.split("\\s*,\\s*"));
items.sort(Comparator.naturalOrder());
items.sort(Comparator.comparingInt(o -> Integer.parseInt(o.split("\\D")[0])));
List<String> merged = mergeRanges(items);
List<String> mergeLetters = mergeLetters(merged);
System.out.println(("Result: " + mergeLetters));