import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Path;

import static java.util.stream.Collectors.toList;

public class ReadFileInManyColumns {

  public static void main(String[] args) throws IOException {

    Path path = Paths.get("build/asd.txt");

    List<String> fileLines = Files.readAllLines(path, StandardCharsets.UTF_8);

    for (String fileLine : fileLines) {

      String[] columnArray = fileLine.split("\\s+");

      List<String> lineColumns = Arrays.stream(columnArray).collect(toList());

      doSomethingWithFileLineColumns(lineColumns);

    }
  }

  private static void doSomethingWithFileLineColumns(List<String> lineColumns) {
    System.out.println(lineColumns);
  }

}