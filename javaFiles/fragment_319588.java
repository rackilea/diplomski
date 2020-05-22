import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CategoryMedianCalculator {
  private final Map<String, List<Row>> categories = new HashMap<>();

  public void addRow(String category, double value, double stdDev) {
    List<Row> rows = categories.get(category);
    if (rows == null) {
      rows = new ArrayList<>();
      categories.put(category, rows);
    }
    rows.add(new Row(category, value, stdDev));
  }

  public Map<String, Double> getMedians() {
    Map<String, Double> result = new TreeMap<>();
    for (Map.Entry<String, List<Row>> entry: categories.entrySet()) {
      result.put(entry.getKey(), getMedian(entry.getValue()));
    }
    return result;
  }

  private static double getMedian(List<Row> rows) {
    Collections.sort(rows);
    int index = rows.size() / 2;
    if (rows.size() % 2 == 0) {
      return rows.get(index - 1).stdDev < rows.get(index).stdDev
          ? rows.get(index - 1).value
          : rows.get(index).value;
    } else {
      return rows.get(index).value;
    }
  }

  private static class Row implements Comparable<Row> {
    private final String category;
    private final double value;
    private final double stdDev;

    public Row(String category, double value, double stdDev) {
      this.category = category;
      this.value = value;
      this.stdDev = stdDev;
    }

    @Override
    public int compareTo(Row o) {
      return value == o.value ? 0 : value > o.value ? 1 : - 1;
    }
  }

  public static void main(String[] args) {
    CategoryMedianCalculator calc = new CategoryMedianCalculator();
    calc.addRow("A", 0.2, 0.05);
    calc.addRow("A", 1.3, 0.08);
    calc.addRow("A", 0.1, 0.1);

    calc.addRow("B", 0.6, 0.9);
    calc.addRow("B", 1.1, 0.6);
    calc.addRow("B", 0.7, 0.01);
    calc.addRow("B", 0.9, 0.05);
    calc.addRow("B", 0.1, 0.01);
    calc.addRow("B", 0.2, 0.08);

    calc.addRow("C", 0.5, 0.3);
    calc.addRow("C", 1.0, 0.14);
    calc.addRow("C", 2.1, 0.1);
    calc.addRow("C", 0.9, 0.04);

    for (Map.Entry<String, Double> median : calc.getMedians().entrySet()) {
      System.out.printf("%s: %.1f%n", median.getKey(), median.getValue());
    }
  }
}