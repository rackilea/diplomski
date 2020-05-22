Collections.sort(posts, new Comparator<Post>() {
     @Override
     public int compare(Post lhs, Post rhs) {
         int nameComp = lhs.getName().compareToIgnoreCase(rhs.getName());
         if (nameComp == 0) {
             Integer lhsSize = lhs.getSize();
             Integer rhsSize = rhs.getSize();

             return lhsSize.compareTo(rhsSize);
         }
         else {
             return nameComp;
         }
     }
});