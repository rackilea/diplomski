import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PetalGrouping {
    private static final String input = "Petal_Length\t0\t1.3 - 2.42\n"
        + "Petal_Length\t1\t2.42 - 3.54\n"
        + "Petal_Length\t2\t3.54 - 4.66\n"
        + "Petal_Length\t3\t4.66 - 5.78\n"
        + "Petal_Length\t4\t5.78 - 6.9\n"
        + "Petal_Width\t 5\t0.3 - 0.76\n"
        + "Petal_Width\t 6\t0.76 - 1.2200000000000002\n"
        + "Petal_Width\t 7\t1.2200000000000002 - 1.6800000000000002\n"
        + "Petal_Width\t 8\t1.6800000000000002 - 2.14\n"
        + "Petal_Width\t 9\t2.14 - 2.6\n"
        + "Sepal_Length\t10\t4.3 - 5.02\n"
        + "Sepal_Length\t11\t5.02 - 5.739999999999999\n"
        + "Sepal_Length\t12\t5.739999999999999 - 6.459999999999999\n"
        + "Sepal_Length\t13\t6.459999999999999 - 7.179999999999999\n"
        + "Sepal_Length\t14\t7.179999999999999 - 7.899999999999999\n"
        + "Sepal_Width\t 15\t2.3 - 2.76\n"
        + "Sepal_Width\t 16\t2.76 - 3.2199999999999998\n"
        + "Sepal_Width\t 17\t3.2199999999999998 - 3.6799999999999997\n"
        + "Sepal_Width\t 18\t3.6799999999999997 - 4.14\n"
        + "Sepal_Width\t 19\t4.14 - 4.6";

public static void main(String... args) {
    Map<String, List<Attribute>> map = new HashMap<String, List<Attribute>>();
    String[] lines = input.split("\n");
    for (String line : lines) {
        Attribute attribute = Attribute.parse(line);
        List<Attribute> attributeList = map.get(attribute.getName());
        if (attributeList == null) {
            attributeList = new ArrayList<Attribute>();
            map.put(attribute.getName(), attributeList);
        }
        attributeList.add(attribute);
    }
    System.out.println(map);
}


}

class Range {
private double from;
private double to;

private Range(double from, double to) {
    this.from = from;
    this.to = to;
}

public static Range parse(String string) {
    String[] parts = string.split(" ");
    if (parts.length != 3) { throw new RuntimeException("Parsing failed for line: " + string); }
    return new Range(Double.parseDouble(parts[0].trim()), Double.parseDouble(parts[2].trim()));
}

@Override
public String toString() {
    return "{from=" + from + ", to=" + to + '}';
}
}

class Attribute {
private String name;
private int index;
private Range range;

protected Attribute(String name, int index, Range range) {
    this.name = name;
    this.index = index;
    this.range = range;
}

public static Attribute parse(String line) {
    String[] lineParts = line.split("\t");
    if (lineParts.length != 3) { throw new RuntimeException("Parsing failed for line: " + line); }
    String name = lineParts[0].trim();
    int index = Integer.parseInt(lineParts[1].trim());
    Range range = Range.parse(lineParts[2].trim());
    return new Attribute(name, index, range);
}

@Override
public String toString() {
    return "index=" + index + " " + range + '}';
}

public String getName() {
    return name;
}
}