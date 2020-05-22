public static void main(String[] args) throws Exception {
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    int [] wt=new int[5];
    int W = 1000;

    System.out.println("Enter Weight 5 weights");
    for(int i=0; i<5; i++)
    {
        wt[i]=Integer.parseInt(reader.readLine());
    }   
    int bestClassicSolution = knapsack(wt, W);
    int differenceAgainstMaxWeight = W - bestClassicSolution;
    int newMaxWeight = W + differenceAgainstMaxWeight;
    int bestMaxSolution = reversedKnapsack(wt, newMaxWeight, W);
    int differenceAgainstWeightAboveW = W - bestMaxSolution;

    if (differenceAgainstWeightAboveW <= differenceAgainstMaxWeight){
        System.out.println(bestMaxSolution);
    } else {
        System.out.println(bestClassicSolution);
    }
}

public static int reversedKnapsack(int wt[], int W, int min) {
    //similar to knapsack method, but the solution must be as small as possible and must be bigger than min variable
}