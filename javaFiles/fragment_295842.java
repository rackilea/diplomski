//To hold my codes for remote say on, off temp+, temp-, swing etc
public class TransmissionCodes{
    private int[] transmission; //will use to store and send transmssion
    private int frequency;//fed from my properties file
    private String countPattern; // Fed as string from my properties file

    //This modification in the getter did the trick
    private int[] getTransmission() {
        int pulses = 1000000/this.frequency;
        String[] countArray = this.countPattern.split(",");
        int[] anotherFix = new int[countArray.length];
        for (int i = 0; i < countArray.length; i++) {
            anotherFix[i] = Integer.parseInt(countArray[i]) * pulses;
        }
        return anotherFix;
    }
    //+getters +setters +constructor
}

//To hold all the TransmissionCodes objects
SparseArray<TransmissionCodes> sequence ;

//power on
sequence.put(0,     new TransmissionCodes(38000,    "123,339,23,54,23,14,23,16,21,14,21,16,21,14,23,16,21,16,21,14,23,53,23,15,22,16,21,54,23,14,23,16,21,16,21,54,23,54,23,53,23,54,23,14,23,54,23,14,23,54,22,54,23,16,21,16,21,14,23,14,23,16,21,16,21,54,23,54,23,15,22,15,22,14,23,14,23,14,23,14,23,53,23,54,23,14,23,14,23,16,21,54,23,14,23,16,21,14,23,16,21,14,23,16,21,14,23,53,23,53,23,54,23,54,23,2500"));
//power off
sequence.put(1,     new TransmissionCodes(38000,    "123,339,23,54,23,14,23,16,21,14,21,16,21,14,23,16,21,16,21,14,23,53,23,15,22,16,21,54,23,14,23,16,21,16,21,54,23,54,23,53,23,54,23,14,23,54,23,14,23,54,22,54,23,16,21,16,21,14,23,14,23,16,21,16,21,54,23,54,23,15,22,15,22,14,23,14,23,14,23,14,23,53,23,54,23,14,23,14,23,16,21,54,23,14,23,16,21,14,23,16,21,14,23,16,21,14,23,53,23,53,23,54,23,54,23,2500"));


//IR call in main Activity
findViewById(R.id.button).post(new Runnable() {
    public void run() {
        ConsumerIrManager mCIR = (ConsumerIrManager) getSystemService(android.content.Context.CONSUMER_IR_SERVICE);
        mCIR.transmit(sequence.getFrequency, sequence.getTransmission);
    }
});