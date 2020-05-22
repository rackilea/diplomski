static Gson gs = new Gson();

public static void main(String[] args) {
    Object obj = new int[] { 1, 2, 3, 4 };
    System.out.println(gs.toJson(obj));
}

// output: [1,2,3,4]