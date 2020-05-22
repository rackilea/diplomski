public static void main(String[] args) {
    File file = new File("root.xml");
    JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
    Unmarshaller unmarshaller = jaxbCntext.createUnmarshaller();
    Root root = (Root) unmarshaller.unmarshal(file);

    P_to_P pToP = root.getComp().getPToP();
    process(pToP);
}

private static void process(P_to_P pToP) {
   if (pToP == null)
       return;

   // do anything you like here

   process(pToP.getP());
}

private static void process(P p) {
   if (p == null)
       return;

   // do anything you like here

   if (p.getpToPList() == null)
       return;
   for (P_to_P pToP : p.getpToPList()) {
       process(pToP);
   }
}