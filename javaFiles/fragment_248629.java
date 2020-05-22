import java.nio.file.Files;
import java.nio.file.Paths;
[...]

public static double[][] readPointCloudFile(String filename, int n) {
  double[][] points = new double[n][];
  String delimiter = ",";
  String filecontent = new String(Files.readAllBytes(Paths.get(filename)));
  Scanner sc = new Scanner(filecontent);
  for (int i = 0; i < n; i++) {
      String line = sc.nextLine();
      points[i] = stringsToDoubles(line.split(delimiter));
  }
  return points;
}