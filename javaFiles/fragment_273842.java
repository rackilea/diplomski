Compiled from "ArrayTest.java"
class ArrayTest {
  ArrayTest();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public int[] withNew();
    Code:
       0: iconst_4      
       1: newarray       int
       3: astore_1      
       4: aload_1       
       5: areturn       

  public int[] withInitializer();
    Code:
       0: iconst_4      
       1: newarray       int
       3: dup           
       4: iconst_0      
       5: iconst_0      
       6: iastore       
       7: dup           
       8: iconst_1      
       9: iconst_0      
      10: iastore       
      11: dup           
      12: iconst_2      
      13: iconst_0      
      14: iastore       
      15: dup           
      16: iconst_3      
      17: iconst_0      
      18: iastore       
      19: astore_1      
      20: aload_1       
      21: areturn       
}