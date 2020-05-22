SelectGuiSubitemTestObject object_for_select = ((SelectGuiSubitemTestObject) to[0]);
      try {
//      ITestDataList dataList = (ITestDataList)object_for_select.getTestData("list");
//      ITestDataElementList elementList = (ITestDataElementList)dataList.getElements();
//          for(int i = 0; i<elementList.getLength(); i++) {
//        This statement prints the Items of the Listbox or combo box.
//        System.out.println("Item Index  "+i+" "+elementList.getElement(i).getElement().toString());
//      }
    object_for_select.select(what_to_set);
  }