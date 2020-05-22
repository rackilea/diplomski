Collections.sort(indexResponsesList, new Comparator<UserData>() {
        @Override
        public int compare(UserData userData, UserData t1) {
            Long idea1 = new Long(userData.getCreatedAt());// here pass rating value.
            Long idea2 = new Long(t1.getCreatedAt());// here pass rating value.
            return idea2.compareTo(idea1);
        }
    });
    if (indexItemAdapter != null)
        indexItemAdapter.notifyDataSetChanged();