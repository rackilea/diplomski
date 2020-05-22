VTDGen vg= new VTDGen();

if (vg.parseFile("input.xml",false)){
   VTDNav vn = vg.getNav();
   vn.toElement(VTDNav.FIRST_CHILD);
   int i = vn.getText();
   if (i!=-1)
   System.out.println(" text node is "+vn.toString(i));

}