public static int increase_user(int user) {
        int number = 3;
        if (number < 10)
            user++;

        return user;
    }

    public static void main(String[] args) {
        int user = 10;
        user = increase_user(user);
        System.out.println(user);
    }