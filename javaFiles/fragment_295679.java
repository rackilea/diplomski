new org.pdfclown.documents.interaction.annotations.Rectangle(
  page,
  new Rectangle(50, 370, 100, 30),
  "Text of the Rectangle annotation"
  ).withColor(DeviceRGBColor.get(Color.RED))
   .withBorder(new Border(1, new LineDash(new double[]{5})))
   .withAuthor("Stefano")
   .withSubject("Rectangle")
   .withPopup(new Popup(
     page,
     new Rectangle2D.Double(200, 325, 200, 75),
     "Text of the Popup annotation (this text won't be visible as associating popups to markup annotations overrides the former's properties with the latter's)"
     ));