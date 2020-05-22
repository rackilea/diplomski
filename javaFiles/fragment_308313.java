private static String r16 = "(?s)(<img.*?)(src\\s*?=\\s*?(?:\"|').*?(?:\"|'))";
private static String in10 = "<><><><><img width=1 height=888 src=\"bnm.jpg\"<><><><><img src=\"\"> <img src = \"\"><img src ='folder1/folder2/bnm.jpg'><><><img src =\"'>";
private static String r14 = "(?s)\\/|\\=";




    String path="images/";
    String name="";

   Pattern p = Pattern.compile(r16);

   Matcher m = p.matcher(in10); 


   StringBuffer sb = new StringBuffer();
   int i=1;
   while(m.find())
   {
        String g0 = m.group();
        String g2 = m.group(2);
        System.out.println("Main group"+i+":"+g0);
        System.out.println("Inner group1:"+m.group(1));
        System.out.println("Inner group2:"+g2);




            String[] names=g2.split(r14);
            printNames(names);

            /*
             * src="/folder1/folder2/blah.jpg"  --->  blah.jpg
             * src="bnm.jpg"                    --->  src="bnm.jp"
             */

            if(names.length>=1)
            {
                name = names[names.length-1];
            }
            else
            {
                name = "";
            }
        //Name might be empty string.
        name = name.replaceAll("\"|'","");
        System.out.println("Retrieved Name:"+name);
        m.appendReplacement(sb,"$1src=\""+path+name+"\"");
        i++;
   }
   m.appendTail(sb);
    INPUT=sb.toString();
   System.out.println("Final Result:"+INPUT);
   System.out.println("Original____:"+in10);
   System.out.println("Count:"+m.groupCount());        
}