import java.lang.System; //imported by default

public class Portsmouth {

    private int id;
    Date date;
    private int[] arrow; 

    public Portsmouth(int id, Date data, int[] arr){
      this.id = id;
      this.date = date;
      arrow = new int[60];

      System.arraycopy(arr, 0, arrow, 0, 60);

      /**for(int i=0;i<60;i++){
         arrow[i] = arr[i];
      }**/
    }

}