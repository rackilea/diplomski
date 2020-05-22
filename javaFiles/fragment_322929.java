java.util.Collections.sort(userList, new Comparator<User>(){
        @Override
        public int compare(User lhs, User rhs) {
            return lhs.getScore() - rhs.getScore();
        }

    });