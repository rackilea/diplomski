public static void main(String[] args)
{

    double distance = 0;            //initiates all numbers needed and sets to 0)
    int r[];
    int n[];
    int X1[];
    int X2[];
    int Y1[];
    int Y2[];

    Scanner q = new Scanner (System.in);

    int t = q.nextInt();            //Scans in t (Number of lines to follow)

    r = new int[t];
    n = new int[t];
    X1 = new int[t];
    X2 = new int[t];
    Y1 = new int[t];
    Y2 = new int[t];

    for(int i = 0; i<t; i++) {
        r[i] = q.nextInt();            //Scans in r  (Number of Random Objects)
        n[i] = q.nextInt();            //Scans in n  (Number of Simulations)
    }

    for(int i = 0; i < t; i++)
    {
        Random rand = new Random (r[i]);
        X1[i] = rand.nextInt(n[i]);      // fills index(s) i with Random number in X1 values
        X2[i] = rand.nextInt(n[i]);      // fills index(s) i with Random number in X2 values
        Y1[i] = rand.nextInt(n[i]);      // fills index(s) i with Random number in Y1 values
        Y2[i] = rand.nextInt(n[i]);      // fills index(s) i with Random number  in Y2 values

        distance = Math.sqrt( Math.pow((X2 [i] - X1 [i] ), 2) + Math.pow((Y2 [i] - Y1 [i] ), 2) );
        System.out.println(distance);
    }

}