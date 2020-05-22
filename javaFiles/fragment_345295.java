long started2 = System.nanoTime();
 @SuppressWarnings("unchecked")
 List<String> lst = (List<String>)sqlMap.queryForList("map.testing");
 BufferedWriter bw = new BufferedWriter(new FileWriter("test2.csv"));
 for(String str : lst){
    bw.write(str);
 }
 long time2 = (System.nanoTime()-started2);
 System.out.println("with list: " + time2);