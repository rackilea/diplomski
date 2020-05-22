public String userWithName(String s) {
        //gets a list of String usernames from list of users
        List<String> usernames = listofusers.stream().map(User::getUserName).collect(Collectors.toList());
        if (usernames.contains(s)) {
            return s;
        } else {
            return null;
        }
    }

    public registerUser(User x){
        if(!listofusers.contains(x)) {
            listofusers.add(x);
        }
    }