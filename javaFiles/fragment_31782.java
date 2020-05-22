public class assignment1question1 {

    public static void main(String[] args) {
        int[] a = {1,3,4,3,5};
        int[] b = {1,3,4,1,7,3};
        System.out.print(listIntersection(a,b));
    }

    public static int listIntersection(int[] a, int[] b) {
        int intersect = 0;

        for(int i = 0; i < a.length; i++) {
            boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if(a[i] == a[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                for(int k = 0; k < b.length; k++) {
                    if (a[i] == b[k]) {
                        intersect++;
                        break;
                    }
                }
            }
        }
        return intersect; 
    }
}