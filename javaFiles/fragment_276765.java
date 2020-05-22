Arrays.sort(multi, new Comparator<String[]>(){
    @Override
    public int compare(String[] first, String[] second){
        // compare the first element
        int comparedTo = first[0].compareTo(second[0]);
        // if the first element is same (result is 0), compare the second element
        if (comparedTo == 0) return first[1].compareTo(second[1]);
        else return comparedTo;
    }
});