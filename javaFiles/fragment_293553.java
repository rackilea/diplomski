User user = twitter.showUser("lt_deportes");
       long cursor = -1;
        PagableResponseList<UserList> lists;
                do {
            lists =  twitter.list().getUserListMemberships(user.getId(),1000,cursor,false);
            for (UserList list : lists) {
                System.out.println("id:" + list.getId() + ", name:" + list.getName() + ", description:"
                        + list.getDescription() + ", slug:" + list.getSlug() + "");
            }
        } while ((cursor = lists.getNextCursor()) != 0);