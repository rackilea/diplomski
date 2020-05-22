public static void main(String[] args) {
    ArrayList<Double> arrayDoubles = new ArrayList<>();
    for (int i = 0; i < 10; i++){
        arrayDoubles.add(0.10);
    }

    for (int j = 0; j < 5; j++){
        arrayDoubles.add(0.20);
    }

    for (int k = 0; k < 4; k++){
        arrayDoubles.add(0.50);
    }

    for (int l = 0; l < 6; l++){
        arrayDoubles.add(1.00);
    }


    printAllSubsets(arrayDoubles, arrayDoubles.size(), 3.20);



}

static void printAllSubsetsRec(ArrayList<Double> arr, int n, Vector<Double> v,
                               double sum)
{
    // If remaining sum is 0, then print all
    // elements of current subset.
    if (Math.round(sum * 10.0) / 10.0 == 0) {
        for (int i=0;i<v.size();i++)
            System.out.print( v.get(i) + " ");
        System.out.println();
        return;
    }

    // If no remaining elements,
    if (n == 0)
        return;

    // We consider two cases for every element.
    // a) We do not include last element.
    // b) We include last element in current subset.
    printAllSubsetsRec(arr, n - 1, v, Math.round(sum * 10.0) / 10.0);
    Vector<Double> v1=new Vector<Double>(v);
    v1.add(arr.get(n-1));
    printAllSubsetsRec(arr, n - 1, v1, Math.round(sum * 10.0) / 10.0 - arr.get(n-1));
}

static void printAllSubsets(ArrayList<Double> arr, int n, double sum)
{
    Vector<Double> v= new Vector<Double>();
    printAllSubsetsRec(arr, n, v, Math.round(sum * 10.0) / 10.0);
}