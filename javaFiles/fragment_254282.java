public static void main(String args[]) {
    Map<String, Set<String>> subList = new HashMap<>();

      List<String> myList = new ArrayList<String>();
      myList.add("Text_1");
      myList.add("XYZ_3");
      myList.add("ABC_1");
      myList.add("Text_2");
      myList.add("Text_3");
      myList.add("XYZ_1");
      myList.add("XYZ_2");
      myList.add("ABC_2");

      for (String item : myList) {
          String suffix = item.substring(item.lastIndexOf("_"));
          if (subList.containsKey(suffix))  continue;
          Set<String> tempSet = new HashSet<String>();
          tempSet.add(item);
          for (String value : myList) {
              if (value.endsWith(suffix)) {
                  tempSet.add(value);
              }
          }
          subList.put(suffix, tempSet);
      }
      System.out.println(subList);
  }