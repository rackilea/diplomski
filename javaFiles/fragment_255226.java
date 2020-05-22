String input = "I love programming, pizza, coke and chips";
String other = "I programming, chips";
String[] parts = input.replaceAll("[,.;-]", "").split("\\s");
String[] otherparts = other.replaceAll("[,.;-]", "").split("\\s");
List<String> missing = new ArrayList<>();
int pnt = 0;
for (int i=0; i < parts.length; ++i) {
    if (parts[i].equals(otherparts[pnt])) {
        ++pnt;
    }
    else {
        missing.add(parts[i]);
    }
}

System.out.println(Arrays.toString(parts));
System.out.println(Arrays.toString(missing.toArray()));

[I, love, programming, pizza, coke, and, chips]
[love, pizza, coke, and]