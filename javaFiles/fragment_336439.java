Collections.sort(posts, new Comparator<Post>() {
        @Override
        public int compare(Post lhs, Post rhs) {
            String left  = lhs.getName().toLowerCase();
            String right = rhs.getName().toLowerCase();

            if (left.equals(right)) {
                return lhs.getName().compareTo(rhs.getName());
            }
            else {
                return left.compareTo(right);
            }
});