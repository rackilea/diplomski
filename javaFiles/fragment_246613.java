private static boolean check(ArrayList<Node> list, int num) {
    for (Node node : list) {
        if(node.data == num)
            return false;
    }
    return true;
}