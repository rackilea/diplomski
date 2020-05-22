private List<Bean> populateBeanList(List<Bean> myList, String[] descArray, String[] photoArray){

     for(int i=0; i< descArray.length; i++){

      Bean bean = new Bean();
      bean.setText(descArray[i]);
      bean.setUrl(photoArray[i]);
      myList.Add(bean);
     }

   return myList;
}