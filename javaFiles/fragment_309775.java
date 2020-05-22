public class Donation {
    private static int[] donArray = {10, 5, 30, 20};
    static{
        Arrays.sort(donArray);
    }

    public static void main(String[] args){
        int paid = 13;
        System.out.println("Applied Donation: " + applyDonation(paid));
    }

    private static int applyDonation(int paid) {
        int applied = 0;
        for(int range: donArray){
            if(range <= paid)
                applied = range;
            else
                break;
        }
        return applied;
    }
}