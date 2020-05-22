Map<String, String> map = new HashMap<>();

while(fileout.hasNext() && fileout2.hasNext()){
    username = fileout.next();
    password = fileout2.next();
    map.put(username, password);
}

...

if (password.equals(map.get(username)) {
  ...
}