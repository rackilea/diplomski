public class Job extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {
    /* create the Hadoop Job here */
  }

  public static void main(String[] args) {
    int ret;
    try {
      ret = ToolRunner.run(new Job(), args);
    } catch (Exception e) {
      e.printStackTrace();
      ret = -1;
    }
    System.exit(ret);
  }
}