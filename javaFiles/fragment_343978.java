private static class Holder {
    final static int[] NUMS = { 1, 2, 3 };
}

private Main() {
    for (int i = 0; i < STR.length(); i++)
        map.put(Holder.NUMS[i], STR.charAt(i)); // No compiler error!
}