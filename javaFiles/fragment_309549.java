List<String> abc = Arrays.asList("a:b:c:d:e", "p:q:r:s:t:u:v", "m:n:o");
String a[];
String array[][] = new String[abc.size()][];
for(int i=0;i<abc.size();i++){
    a = abc.get(i).split(":");
    array[i] = new String[a.length];
    for(int j=0; j<a.length; j++) array[i][j] = a[j];
}