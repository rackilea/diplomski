public class DataProvider {
static int a;
static String b;

static {
    a = readRollConfiguration();
    b = readNameConfiguration();
}

 public static int getRollConfig() {//no reload, gets the current value
      return a;
  }

  public static int getNameConfig() {//no reload, gets the current value
      return b;
  }


  public static int reloadAndGetRollConfig() {//reload and get the new value
      a = readRollConfiguration();
      return a;
  }

  public static int reloadAndGetNameConfig() {//reload and get the new value
      b = readNameConfiguration();
      return b;
  }
}