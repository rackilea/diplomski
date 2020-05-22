static class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1 == null) {
            return (o2 == null) ? 0 : 1;
        }
        if (o2 == null) {
            return -1;
        }

        String username1 = o1.getName();
        String username2 = o2.getName();
        if (username1 == null) {
            return username2 == null ? 0 : 1;
        }
        if (username2 == null) {
            return -1;
        }

        int namecomp = username1.compareTo(username2);
        if (namecomp != 0) {
            return namecomp;
        }

        Integer useramount1 = o1.getAmount();
        Integer useramount2 = o2.getAmount();
        if (useramount1 == null) {
            return useramount2 == null ? 0 : 1;
        }
        if (useramount2 == null) {
            return -1;
        }
        return useramount1.compareTo(useramount2);
    }
}