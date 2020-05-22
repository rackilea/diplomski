public class Arraydeletion {

    public static int[] delete (int[] a, int delValPos){
        if (delValPos  < 0 || delValPos >= a.length)
            throw new SomeException(); // TODO decide which exception to throw
        int[] newArray = new int[a.length-1];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i!=delValPos) {
                newArray[index] = a[i];
                index++;
            }
        }
        return newArray;
    }
}