import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortParams {
  private List<SortParam> sortParamList;

  public SortParams(String commaSeparatedString) {
    sortParamList = Arrays.stream(commaSeparatedString.split(","))
      .map(p -> SortParam.valueOf(p))
      .collect(Collectors.toList());
  }

  public List<SortParam> getSortParamList() {
    return this.sortParamList;
  }

  public enum SortParam {
    FOO, BAR, FOOBAR;
  }
}