for(XSLFShape shape : slide){
        shape.getAnchor();

        if (shape instanceof XSLFTable){
            XSLFTable t = (XSLFTable) shape;

            if(t.getShapeName().equals("Table1")){
                t.getCell(1,1).clearText();
                t.getCell(1,1).addNewTextParagraph().addNewTextRun().setText("TABELE 1");
            }
          }
        }