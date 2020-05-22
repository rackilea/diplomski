Comparator myComp2 = new Comparator<AVLNode>() {
      @Override
      public int compare(AVLNode n1, AVLNode n2) {
        return n1.getKey().compareTo(n2.getKey());
      }
    };