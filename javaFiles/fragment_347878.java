public void addWithSuffix(String email) {
    if(list.contains(email)) {
        int number = 0;
        String[] tmp = email.split("@");

        for(; list.contains(tmp[0] + number + "@" + tmp[1]); number++){}

        list.add((tmp[0] + number + "@" + tmp[1]));
    }
    else {
        list.add(email);
    }
}