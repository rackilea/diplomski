public static Map<String,List<User>> category(List<User> unfilteredList){
        Map<String,List<User>> result = new HashMap<>();
        for(User u :unfilteredList){
            String inerest = u.getInterest();
            if(result.containsKey(u.getInterest())){
                List<User> users = new ArrayList<>(result.get(inerest));
                users.add(u);
                result.put(inerest, users);
            }else{
                List<User> users = new ArrayList<>();
                users.add(u);
                result.put(inerest, users);
            }
        }
        return result;
    }