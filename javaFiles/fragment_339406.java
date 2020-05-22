String kws = br.readLine();
String[] words = kws.split(" or ");

kw1 = words[0];
if(words.length > 1)
    kw2 = words[1];
System.out.println(zoogle.top5search(kw1, kw2));