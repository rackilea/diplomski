public class PathTokens {

    private final List<String> tokens = new ArrayList<>();

    public PathTokens(){};

    public PathTokens(final List<String> tokens) {
      this.tokens.addAll(tokens);
    }


    public boolean isTokenInPath(String path) {
      if (path != null) {
        for (String s : tokens) {
            if (path.contains(s)) {
                return true;
            }
        }
      }
      return false;
    }

    public String getTokenFromPath(String path) {
      if (path != null) {
          for (String s : tokens) {
              if (path.contains(s)) {
                  return s;
              }
          }
      }
      return null;
  }

  public List<String> getTokens() {
      return tokens;
  }
}