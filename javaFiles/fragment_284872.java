private static final Comparator<String> phoneNoComp = new Comparator<String>(){
      @Override
      public int compare(final String s1, final String s2) {
        return PhoneNumberUtils.compare(s1,s2);
      }
  };

  private Set<String> getCommonPhoneNumbers(final List<String> list1 , final List<String> list2){

      Set<String> common = new HashSet<String>();

      Collections.sort(list1, phoneNoComp);
      Collections.sort(list2, phoneNoComp);

      int size1 = list1.size();
      int size2 = list2.size();
      int i = 0, j = 0;

      while(i < size1 && j < size2){
          int comparison = PhoneNumberUtils.compare(list1.get(i) , list2.get(j));
          if( comparison == 0) { // found a common element.
              common.add(list1.get(i));
              i++;
              j++;
          }
          else if(comparison == 1){
              j++;
          }
          else{
              i++;
          }
      }

      return common;
  }