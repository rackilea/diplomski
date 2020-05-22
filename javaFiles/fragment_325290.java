public class SimpleSelector {
  public Optional<String> tag_name;
  public Optional<String> id;
  public ArrayList<String> clazz;
}
// ...
int a = id.empty() ? 0 : 1;