...
    @Override
    public PagingLoadResult<Post> getPosts(PagingLoadConfig config) {
        if (posts == null) {
            loadPosts();
        }

        if (config.getSortInfo().size() > 0) {
            SortInfo sort = config.getSortInfo().get(0);
            if (sort.getSortField() != null) {
                final String sortField = sort.getSortField();
                if (sortField != null) {
                    Collections.sort(posts, sort.getSortDir().comparator(new Comparator<Post>() {
                        public int compare(Post p1, Post p2) {
                            if (sortField.equals("forum")) {
                                return p1.getForum().compareTo(p2.getForum());
                            } else if (sortField.equals("username")) {
                                return p1.getUsername().compareTo(p2.getUsername());
                            } else if (sortField.equals("subject")) {
                                return p1.getSubject().compareTo(p2.getSubject());
                            } else if (sortField.equals("date")) {
                                return p1.getDate().compareTo(p2.getDate());
                            }
                            return 0;
                        }
                    }));
                }
            }
        }

        ArrayList<Post> sublist = new ArrayList<Post>();
        int start = config.getOffset();
        int limit = posts.size();
        if (config.getLimit() > 0) {
            limit = Math.min(start + config.getLimit(), limit);
        }
        for (int i = config.getOffset(); i < limit; i++) {
            sublist.add(posts.get(i));
        }
        return new PagingLoadResultBean<Post>(sublist, posts.size(), config.getOffset());
    }
...