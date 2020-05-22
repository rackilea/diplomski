recursion(3, new String(), solutions, "");
//...
private static void recursion(int n, String str, ArrayList<String> sol, String depth) {
    System.out.println(depth + str);
    //...
        if(left == right)
            recursion(n, str + "(", sol, depth + "    ");
        else if(right < left) {
            if(left < n)
                recursion(n, str + "(", sol, depth + "    ");
            recursion(n, str + ")", sol, depth + "    ");
}