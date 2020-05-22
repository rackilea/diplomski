List<String>[] tab = new ArrayList[5];
    tab[0] =  new ArrayList<String>(Arrays.asList("1242"));
    tab[1] =  new ArrayList<String>(Arrays.asList("London", "Paris"));
    tab[2] =  new ArrayList<String>(Arrays.asList("England", "France"));
    tab[3] =  new ArrayList<String>(Arrays.asList("Finance"));
    tab[4] =  new ArrayList<String>(Arrays.asList("No"));

    StringBuffer buffer;

    for(int j=1; j<=2; j++){
        buffer = new StringBuffer(tab[0].get(0)).append(" ");
        for(int i = 1; i < tab.length; i++){

          List<String> list = tab[i];

          if(list.size() == 1){
             buffer.append(list.get(0)).append(" ");
          }else{
             buffer.append(list.get(j - 1)).append(" ");
          }



        }
        System.out.println(buffer.toString());
    }