public class Test
  {
    public static void main(String[] args){
      compareArrays(new String[]{"Test1", "Test2", "Test3"},new String[]{"Test1", "Test2", "Test3"});
      compareArrays(new String[]{"Test1", "Test2", "Test3"},new String[]{"Test1", "Test2", "Test4"});
      compareArrays(new String[]{"Test1", "Test2", "Test3"},new String[]{"Test1", "Test2"});
      compareArrays(new String[]{"Test1", "Test2"},new String[]{"Test1", "Test2", "Test3"});
    }
    private static void compareArrays(String[] test,String[] test2){
      if(test.length > test2.length){
        System.out.println("Scenario 3");
      }
      else if(test2.length > test.length){
        System.out.println("Scenario 4");
      }
      else {
        boolean same = true;
        for (int a=0;a<test.length;a++){
          if(!test[a].equalsIgnoreCase(test2[a])){
            same = false;
          }
        }
        if (same){
          System.out.println("Scenario 1");
        }
        else {
          System.out.println("Scenario 2");
        }
      }
    }
  }