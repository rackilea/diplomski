package my.package_name;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class LowerArray extends UDF {
  public List<Text> evaluate(List<Text> input) {
    List<Text> output = new ArrayList<Text>();
    for (Text element : input) {
      output.add(new Text(element.toString().toLowerCase()));
    }
    return output;
  }
}