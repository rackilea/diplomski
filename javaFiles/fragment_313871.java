private static ArrayList<Integer> trianglenumbers = new ArrayList<>();

public static int triangleNumber(int n){
    if(trianglenumbers.size() <= n){
        if(n == 1)
            trianglenumbers.add(1);
        else
            trianglenumbers.add(triangleNumber(n-1) + n);
    }
    return trianglenumbers.get(n-1);
}