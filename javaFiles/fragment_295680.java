new StaticNote(
  page,
  new Rectangle(250, 90, 150, 70),
  "Text of the Callout note annotation"
  ).withLine(
     new StaticNote.CalloutLine(
       page,
       new Point(250,125),
       new Point(150,125),
       new Point(100,100)
       )
     )
   .withLineEndStyle(LineEndStyleEnum.OpenArrow)
   .withBorder(new Border(1))
   .withColor(DeviceRGBColor.get(Color.YELLOW));