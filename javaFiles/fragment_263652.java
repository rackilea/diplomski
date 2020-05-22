...
XWPFPicture picture = run.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, "Name", Units.pixelToEMU(300), Units.pixelToEMU(150));
System.out.println(picture.getCTPicture());

picture.getCTPicture().getSpPr().addNewLn().setW(Units.toEMU(2.25));
picture.getCTPicture().getSpPr().getLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0,0,0});
System.out.println(picture.getCTPicture());
...