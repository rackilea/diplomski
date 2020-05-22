@GenerateMicroBenchmark
  public int newCharUsed() {
    int len = string.length(), sum = 0;
    for (int i = 0; i < len; i++) sum += new Character(string.charAt(i));
    return sum;
  }

  @GenerateMicroBenchmark
  public int justCharUsed() {
    int len = string.length(), sum = 0;
    for (int i = 0; i < len; i++) sum += Character.valueOf(string.charAt(i));
    return sum;
  }

  @GenerateMicroBenchmark
  public void newChar() {
    int len = string.length();
    for (int i = 0; i < len; i++) new Character(string.charAt(i));
  }

  @GenerateMicroBenchmark
  public void justChar() {
    int len = string.length();
    for (int i = 0; i < len; i++) Character.valueOf(string.charAt(i));
  }

  @GenerateMicroBenchmark
  public void newCharValue() {
    int len = string.length();
    for (int i = 0; i < len; i++) new Character(string.charAt(i)).charValue();
  }

  @GenerateMicroBenchmark
  public void justCharValue() {
    int len = string.length();
    for (int i = 0; i < len; i++) Character.valueOf(string.charAt(i)).charValue();
  }