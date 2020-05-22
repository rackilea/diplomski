List<String> pattern = Arrays.asList("\\d+", "\\.", "\\d+");
 for(int i=0; i<=l.size()-pattern.size(); i++) {
     List<String> subList = l.subList(i, i+pattern.size());
     if(subList.equals(pattern)) {
         subList.clear();
         subList.add("\\d+\\.\\d+");
     }
 }
 System.out.println(l);