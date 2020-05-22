List<String> ls = new ArrayList();
ls.add("Hello");
ls.add("world");
//your foreach sentence
int index = 0;
for(String s : ls) {
    System.out.println("index: " + index);
    System.out.println(s);
    //put your logic here...
    //at the end, update the index manually
    index++;
}