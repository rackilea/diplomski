public int maxDepth() {
        int maxChildrenDepth = 0;
        for (Person prs: people) {
            maxChildrenDepth = Math.max(maxChildrenDepth, prs.maxDepth());
        }
        return 1 + maxChildrenDepth;
    }