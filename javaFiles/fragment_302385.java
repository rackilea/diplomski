import org.apache.commons.lang.StringUtils;
   /**
      <P>{@code java MitchList}</P>
    **/
   public class MitchList  {
      private String[] asData;
      private int iSize;
      public static final void main(String[] igno_red)  {
         MitchList ml = new MitchList();
         test(ml, 0, "hello");
         test(ml, 1, "goodbye");
      }
      public static final void test(MitchList m_l, int i_ndex, String s_tring)  {
         m_l.add(i_ndex, s_tring);

         //Print the array at the last index in asData
         System.out.println(StringUtils.join(m_l.asData, ", "));

        //If you don't have `commons.lang` installed, use this:
        //
        //   for(String s : asData)  {
        //      System.out.print(s + ", ");
        //   }
      }
      public MitchList() {
          asData = new String[2];
          iSize = 0;
      }

      public int iSize() {
          return iSize;
      }


          public void add(int index, String s){
System.out.println("asData.length=" + asData.length + ", iSize=" + iSize + "");
          if (asData.length == iSize) {
System.out.println("1");
              String[] newArray = new String[asData.length*2];
              for (int i=0; i < asData.length; i++) {
                  newArray[i] = asData[i];
              }
              asData = newArray;
      }
          if (index > 0 || index <iSize){
System.out.println("2");
             throw new IllegalArgumentException("index (" + index + ") must be greater than zero and less than size (" + iSize + ")");
          }
System.out.println("asData[" + index + "]=" + asData[index] + "");

          if (asData[index] != ""){
System.out.println("3");
              for (int i = 0; i <iSize; i++){
System.out.println("i=" + i + ", setting s to ");
                 s = asData[index];
              }
          }
          asData[index] = s;
          iSize++;
      }
}