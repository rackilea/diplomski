ArrayList<String> strings2 = 
    s1.parallel()
      .reduce(new ArrayList<String>(), 
              (list, el) -> {
                if (el.contains("a")) {
                    ArrayList<String> added = new ArrayList<>(list);
                    added.add(el);
                    return added;
                }
                return list;
              }, 
              (list1, list2) -> {
                ArrayList<String> merged = new ArrayList<>(list1);
                merged.addAll(list2);
                    return merged;
              });