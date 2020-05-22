while((strLine=br.readLine())!=null){
             System.out.println("Being read:");
             String splits[] = strLine.split(delims);
             System.out.println(splits[0]+" "+splits[4]);
             parsedit.add(splits);
 }