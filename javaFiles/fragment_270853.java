public ArrayList<String> seperateIntoList(String wsdlString){
      String[] resultArray =  wsdlString.split(";");
      ArrayList<String> resultList = new ArrayList<String>(resultArray.size());

      for(String listItem: resultArray) {
          resultList.add(listItem);
      }

      return resultList;
}