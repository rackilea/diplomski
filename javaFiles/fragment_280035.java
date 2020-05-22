public class Main {

    private static String result;

    public static void main(String[] args) {
        String durs = "NNNNNNQQNNNNNNNQNNNNNNNNNNNNNNNN";

        result = "";

        int qCount = 0;
        for(int i = 0; i < durs.length(); i++){
            if (durs.charAt(i) == 'N'){
                // Process accumulated Q's from before
                if (qCount > 0){
                    processQ(qCount);
                    qCount = 0;
                }

                // Do nothing if there is a Q next to us
                if ((i != durs.length() - 1) && durs.charAt(i + 1) == 'Q'){
                    continue;
                }

                result += "1";


            }else{
                qCount++;
            }
        }

        if (qCount > 0){
            processQ(qCount);
        }


        System.out.println(result);
    }

    private static void processQ(int qCount) {
        if (qCount > 0){
            result += (qCount + 1);
            for(int j = 0; j < qCount; j++){
                result += "0";
            }
        }
    }

}