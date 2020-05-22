Scanner input = null;
  try {
      input = new Scanner(new File(file));
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  }

  List<String> list = new ArrayList<String>();
  ArrayList<String> SecondarrayList = new ArrayList<String>();

  String word = null;
  while (input.hasNext()) {
      word = input.next();
      list.add(word);
  }

  int totalSize = 0;

  for (String eachString : list) {

        totalSize +=eachString.length();

        if(totalSize >=100){
            break;
        }else{
          SecondarrayList.add(eachString);
        }
  }

  for (int i = 0; i < SecondarrayList.size(); i++) {
      System.out.println(SecondarrayList.get(i));
  }