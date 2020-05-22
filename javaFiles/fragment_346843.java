public class CapitalizeString implements Runnable {

    char[] chars;
    int start;
    int numThreads;

    public CapitalizeString(char[] chars, int startIndex, int numThreads) {
        this.chars = chars;
        this.numThreads = numThreads;
        start = startIndex;
    }

    @Override
    public void run() {
        for(int x = start; x < chars.length; x += numThreads){
            chars[x] = Character.toUpperCase(chars[x]);
        }
    }
}