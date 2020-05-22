public class BaseScriptInfoParser {
  public interface Factory {
    // Any interface and method name works. These are the most common.
    BaseScriptInfoParser create(Asset.ScriptKindEnum scriptKind);
  }
  // ... rest of the class, including the above constructor
}