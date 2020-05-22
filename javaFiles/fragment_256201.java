public class RandomExample {
    private ArrayList<Integer> occurredNum = new ArrayList<Integer>();
    private Random r = new Random();
    private int play = 5;
    private boolean stopCheck;

    public void Tem() {
        occurredNum.add(play);
    }

    public int getRandomWithoutRepetition() {

        // reset boolean flag
        stopCheck = false;

        while (!stopCheck) {

            // get random num
            play = r.nextInt(9) + 1;

            // asking to the ArrayList if random num is an item already added => if ArrayList contains no primitive data type you should override data type's equals(Object obj) method
            if (! occurredNum.contains(play)) {

                // if num is not contained => add num to ArrayList
                occurredNum.add(play);

                // set stop checking flag
                stopCheck = true;
            }

        }

        // return new num
        return (play);
    }

    public static void main(String[] args) {
        RandomExample t = new RandomExample();
        t.Tem();
        System.out.println(t.getRandomWithoutRepetition());
        System.out.println(t.getRandomWithoutRepetition());
        System.out.println(t.getRandomWithoutRepetition());
        System.out.println(t.getRandomWithoutRepetition());
        System.out.println(t.getRandomWithoutRepetition());
        System.out.println(t.getRandomWithoutRepetition());
        System.out.println(t.getRandomWithoutRepetition());
        System.out.println(t.getRandomWithoutRepetition());
    }
}