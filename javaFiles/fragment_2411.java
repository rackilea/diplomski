public class Trajet {
    private int[][] plan; 
    private Posi deb;

    // This isn't such a big deal, but if no other objects you know are going to use your fields, then its good practice to make them private.

    public Trajet() {
        plan = new int[10][10];
        // Instead of setting every 1st index to 0, the array will automatically be 0 when created. Also, the first index of an array is 0, not 1, in case you didn't know that. And setting the array at the first index to all 1's, you can use Arrays.fill();
        Arrays.fill(plan[0], 1);
        deb = new Posi(1, 1, 'S'); // Where do you use deb? And can we see the Posi class?
    }

    public void affichPlan(int[][] plan) {
        int n, m;
        for (n = 0; n < plan.length; n++) { // It's never a good idea to put the upper limit as a constant, even if you know it. Because if you're wrong, you're program would error out.
            for (m = 0; m < plan[i].length; m++) System.out.print(plan[n][m] + " ");
            System.out.println();
            System.out.println();
        }
    }

    // The reason its not working is because plan is non-static, that means it belongs to a specific object. For you to have plan, you need the object name. To fix this, I made plan static above.
    public static void main(String[] args) {
        Trajet trajet1 = new Trajet(); // Object names are always lowercase, and the second word and onwards are capital. Just how you make variable names in Java.
        Trajet1.affichPlan(trajet1.plan);
    }
}