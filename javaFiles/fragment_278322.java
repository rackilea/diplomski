public class Test {
    public static void main(String[] args) {
        String data= "2.18954459419779,41.40492402705473,0 2.189651379989959,41.40491712193686,0 2.189993453581252,41.40464878075789,43.9919";
        String[] dtx = data.split(",");
        for (int j = 0; j < dtx.length; j++) {
            if(dtx[j].indexOf(' ')>=0) dtx[j] = dtx[j].split(" ")[1];   
            System.out.println("data["+j+"]="+dtx[j]);
        }
    }

}