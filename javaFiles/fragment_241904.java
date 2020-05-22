List<Element> list = Arrays.asList(new Element("abc"), new Element("xyz"), new Element("bde"), new Element("rew"), new Element("aER"),
           new Element("Tre"), new Element("ade"));
   list.subList(0, 4).sort(new MyElementComparator());
   System.out.println(list);

private static class MyElementComparator implements Comparator<Element>{
   Collator spCollator = Collator.getInstance(new Locale("es", "ES"));
   public int compare (Element e1, Element e2){
       return spCollator.compare(e1.getValue(), e2.getValue());
   }
}