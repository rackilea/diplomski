String equation = "18x^75-4x^56+18x^37+18x^19-18x^9-12";
String[] terms = equation.split("\\+|(?=\\-)");
Arrays.stream(terms).forEach(System.out::println);
List list = new LinkedList<Map.Entry<Integer, Integer>>();
Arrays.stream(terms).filter(t -> t.contains("x^")).forEach(
        s -> list.add(new AbstractMap.SimpleEntry(Integer.parseInt(s.split("x\\^")[0]), Integer.parseInt(s.split("x\\^")[1]))));
//Finally, add the constant term.
list.add(new AbstractMap.SimpleEntry(Integer.parseInt(terms[terms.length - 1]), 0));