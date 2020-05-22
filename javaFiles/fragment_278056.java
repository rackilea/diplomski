[s_delima@ml-l-sotiriosd Downloads]$ java -version
java version "1.7.0_45"
Java(TM) SE Runtime Environment (build 1.7.0_45-b18)
Java HotSpot(TM) 64-Bit Server VM (build 24.45-b08, mixed mode)
[s_delima@ml-l-sotiriosd Downloads]$ javac Examples.java 
[s_delima@ml-l-sotiriosd Downloads]$ /usr/java/latest/bin/javap -c Examples
Compiled from "Examples.java"
public class Examples {
  public Examples();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public int answer(java.sql.PreparedStatement) throws java.sql.SQLException;
    Code:
       0: aload_1       
       1: invokeinterface #2,  1            // InterfaceMethod java/sql/PreparedStatement.executeQuery:()Ljava/sql/ResultSet;
       6: astore_2      
       7: aload_2       
       8: invokeinterface #3,  1            // InterfaceMethod java/sql/ResultSet.next:()Z
      13: ifne          26
      16: new           #4                  // class java/lang/IllegalStateException
      19: dup           
      20: ldc           #5                  // String Expected non-empty result
      22: invokespecial #6                  // Method java/lang/IllegalStateException."<init>":(Ljava/lang/String;)V
      25: athrow        
      26: aload_2       
      27: iconst_1      
      28: invokeinterface #7,  2            // InterfaceMethod java/sql/ResultSet.getInt:(I)I
      33: istore_3      
      34: aload_2       
      35: invokeinterface #8,  1            // InterfaceMethod java/sql/ResultSet.close:()V
      40: iload_3       
      41: ireturn       
      42: astore        4
      44: aload_2       
      45: invokeinterface #8,  1            // InterfaceMethod java/sql/ResultSet.close:()V
      50: aload         4
      52: athrow        
    Exception table:
       from    to  target type
           7    34    42   any
          42    44    42   any
}