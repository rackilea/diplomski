Set<String> s3 = new HashSet<String>();
for(String temp : s1){
    if(!s2.contains(temp)){
        s3.add(temp);
    }
}
for (String temp : s2) {
    if (!s1.contains(temp)) {
        s3.add(temp);
    }
}