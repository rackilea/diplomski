public void findFile(String name,File file)
  {
       File[] list = file.listFiles();
       if(list!=null) {
        for (File fil : list)
        {
            if (name.equalsIgnoreCase(fil.getName()))
            {
                System.out.println(fil.getParentFile()+"\\"+name);
            }
        }
       }
  }