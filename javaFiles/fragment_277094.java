String path="C:/Users/hussain.wahid/Desktop/hussain back up/Hussain/Eclipse WorkSpace/SO/poi.jar";
         path=path.replace("\\","/");
         JarFile jar=new JarFile(path);
         ArrayList<String> fileNameList = new ArrayList<String>();

         Enumeration<JarEntry> myEntry = jar.entries();
         while(myEntry.hasMoreElements())
         {
             //System.out.println(myEntry.nextElement().toString());
             fileNameList.add(myEntry.nextElement().toString());
         }
         System.out.println(fileNameList.contains("com/sun/xml/ws/binding/Bind.class"));
        //org/apache/poi/hssf/record/aggregates/