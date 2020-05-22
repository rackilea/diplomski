abstract class BaseToken {
   abstract Pattern getPattern();
}

class H3 extends BaseToken {
  private Pattern pattern = ...

  Pattern getPattern() {
    return pattern;
  }
}

class Whatever extends BaseToken {
  private Pattern aCompletelyDifferentPattern = ...

  Pattern getPattern() {
    return aCompletelyDifferentPattern;
  }
}