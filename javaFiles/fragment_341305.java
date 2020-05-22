myEvent
    .findMemberships()
    .map(new Func1<List<Membership>, List<User>>() {
        @Override
        public List<User> call(List<Membership> memberships) {
            List<User> users = new ArrayList<User>();
            for (Membership membership : memberships) {
                users.add(membership.getUser());
            }
            return users;
         }
    })