String s = "[1,2,3]"
s=s.sbustring(1,s.length-1);
List<Long> numLongs = new ArrayList<Long>();
for(String eachString: s.split(",")){
    try {
        numLongs.add(Long.parseLong(eachString))
    } catch (NumberFormatException e){
        System.out.println("failed to convert : "+s); 
    }
}