public static void getTagNames() {

   ArrayList<Element> elements = readSubElements();
   ArrayList<String> list1 = new ArrayList<>();
   ArrayList<String> list2 = new ArrayList<>();
   setSize(elements.size());

   for (Iterator it = elements.iterator(); it.hasNext();) {
      Element entry = (Element) it.next();
      list1.add(entry.getQualifiedName());
      list2.add(entry.getText());
   }

   setTagNamesAL(list1);
   setTagContentAL(list2);
}