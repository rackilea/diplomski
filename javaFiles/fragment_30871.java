Object[] all = new Object[yourSize];
ProfileInterface [] friends = new ProfileInterface[yourSize];

all = Arrays.copyOf(friendsList.toArray(), friendsList.toArray().length);

for(int i = 0; i < all.length; i ++){
 friends[i] = (ProfileInterface) all[i];
}