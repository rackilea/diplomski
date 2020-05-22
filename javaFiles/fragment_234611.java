Collections.sort(obj, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return new Scanner(s1).nextInt() - new Scanner(s2).nextInt();
    }
});