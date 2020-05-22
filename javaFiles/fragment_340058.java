public class SOArrays {

    private String[] SHS;

    private void setDay(String[] day) {
       SHS = new String[day.length];
       SHS = day;
    }

    private String[] setRange(int min, int max) {
        final String[] values = new String[max];
        for (int i = min - 1; i < values.length; i++) {
        values[i] = String.valueOf((i + 1));
    }
    return values;
    }

    public void process(){
        setDay( setRange(1,5) );

        System.out.print("Finished without errors.");

     }

     public static void main(String[] args){

         new SOArrays().process();
     }
    }