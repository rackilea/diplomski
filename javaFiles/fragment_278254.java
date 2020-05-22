public int[] getIntsFromHex(String hex){
    int[] results = new int[3];

    results[0] = Integer.parseInt(hex.substring(0,2),16);
    results[1] = Integer.parseInt(hex.substring(2,4),16);
    results[2] = Integer.parseInt(hex.substring(4,6),16);

    return results;
}