/var/tmp-> javap -c CastExample

Compiled from "CastExample.java"
public class CastExample<T> {
  public java.util.List<T> typedList;

  public java.util.List<?> untypedList;

  public CastExample();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public T getFirstElement();
    Code:
       0: aload_0       
       1: getfield      #2                  // Field typedList:Ljava/util/List;
       4: iconst_0      
       5: invokeinterface #3,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
      10: areturn       

  public T getFromUntypedArray();
    Code:
       0: aload_0       
       1: getfield      #4                  // Field untypedList:Ljava/util/List;
       4: iconst_0      
       5: invokeinterface #3,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
      10: areturn       
}