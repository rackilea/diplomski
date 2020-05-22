List<String> list = new ArrayList<>();
list.add("-SP005 of 2015");
list.add("-SP001 of 2017");
list.add("-SP003 of 2015");
list.add("-SP001 of 2015");
list.add("-SP001 of 2016");
list.add("-SP002 of 2015");

Collections.sort(list, new Comparator<String>() {
    public int compare(String o1, String o2) {
        int result = o1.split(" ")[2].compareTo(o2.split(" ")[2]);
        if (result == 0) {// if the years are the same, then compare with first element
            return o1.split(" ")[0].compareTo(o2.split(" ")[0]);
        }
        return result;
    }
});

System.out.println("list = " + list);