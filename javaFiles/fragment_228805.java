Collections.sort(
    myList, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        // If a is "11-24-2012", then aLastDash points
        // here ---------^.
        int aLastDash = a.lastIndexOf("-");
        int bLastDash = b.lastIndexOf("-");
        return a.substring(aLastDash+1).compareTo(
               b.substring(bLastDash+1));
      }
    });