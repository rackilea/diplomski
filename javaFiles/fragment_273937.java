Map<Integer, User> amap = new HashMap<Integer, User>(); 
for(User i: a){
    amap.put(i.getId(), i);  //when duplicate User with same Id is added, new User value will replace old one. 
                             //So Id will always be mapped to last User with that Id
}

List<User> newA = new ArrayList(amap.values());