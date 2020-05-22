public static List<String> getXOR(List<String> oneArray, List<String> twoArray) {

Set<String> oneSet = new HashSet<>(oneArray);
Set<String> twoSet = new HashSet<>(twoArray);

oneSet.removeAll(twoArray);// 1. oneSet / twoArray    ,  oneSet !AND twoArray
twoSet.removeAll(oneArray);// 2. twoSet / oneArray    ,  twoSet !AND oneArray
oneSet.addAll(twoSet);     // 3. oneSet U twoSet      ,  oneSet OR   twoSet

return new ArrayList<String>(oneSet);
}