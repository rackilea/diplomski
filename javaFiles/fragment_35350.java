public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new MessagePerformanceTest().get() );
          Field field = PerformanceTest.class.getDeclaredField("baseDirectory");
          field.setAccessible(true);
          MessagePerformanceTest  mpt = new MessagePerformanceTest ();
          field.set( mpt," \folder1\test");
          System.out.println(mpt.get() );
    }

}