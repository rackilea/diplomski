import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medians {
  public static void printMedians(List<Row> rows) {
    if (rows.size() == 0) return;
    Collections.sort(rows);
    int currentCategoryIndex = 0;
    String currentCategory = rows.get(0).category;
    for (int i = 0; i < rows.size(); i++) {
      if (i == rows.size() - 1
          || !currentCategory.equals(rows.get(i + 1).category)) {
        int categorySize = i + 1 - currentCategoryIndex;
        int medianIndex = currentCategoryIndex + categorySize / 2;
        double median;

        if (categorySize % 2 == 0) {
          median = rows.get(medianIndex - 1).stdDev < rows.get(medianIndex).stdDev
              ? rows.get(medianIndex - 1).value
              : rows.get(medianIndex).value;
        } else {
          median = rows.get(medianIndex).value;
        }

        System.out.printf("%s: %.1f%n", currentCategory, median);

        if (i < rows.size() - 1) {
          currentCategory = rows.get(i + 1).category;
          currentCategoryIndex = i + 1;
        }
      }
    }
  }

  private static class Row implements Comparable<Row> {
    private final String category;
    private final double value;
    private final double stdDev;

    public Row(String category, double value, double standardDeviation) {
      this.category = category;
      this.value = value;
      this.stdDev = standardDeviation;
    }

    @Override
    public int compareTo(Row o) {
      if (category.equals(o.category)) {
        return value == o.value ? 0 : value > o.value ? 1 : - 1;
      }
      return category.compareTo(o.category);
    }
  }

  public static void main(String[] args) {
    List<Row> rows = new ArrayList<>();
    rows.add(new Row("A", 0.2, 0.05));
    rows.add(new Row("A", 1.3, 0.08));
    rows.add(new Row("A", 0.1, 0.1));

    rows.add(new Row("B", 0.6, 0.9));
    rows.add(new Row("B", 1.1, 0.6));
    rows.add(new Row("B", 0.7, 0.01));
    rows.add(new Row("B", 0.9, 0.05));
    rows.add(new Row("B", 0.1, 0.01));
    rows.add(new Row("B", 0.2, 0.08));

    rows.add(new Row("C", 0.5, 0.3));
    rows.add(new Row("C", 1.0, 0.14));
    rows.add(new Row("C", 2.1, 0.1));
    rows.add(new Row("C", 0.9, 0.04));
    printMedians(rows);
  }
}