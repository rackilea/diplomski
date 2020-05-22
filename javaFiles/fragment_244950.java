List<String[]> rowList = new ArrayList<String[]>();
  rowList.add(new String[]{"1","a", "abc"});
  rowList.add(new String[]{"2","b", "def"});
  rowList.add(new String[]{"3","c", "ghi"});
  rowList.add(new String[]{"4","a", "jkl"});
  rowList.add(new String[]{"5","d", "mno"});
  rowList.add(new String[]{"6","e", "pqr"});
  rowList.add(new String[]{"7","b", "stu"});

  Set<String[]> s = new TreeSet<String[]>(new Comparator<String[]>() {
         @Override
         public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
        }
   });