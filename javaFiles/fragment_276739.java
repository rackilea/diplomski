PDRectangle pdRectangle = new PDRectangle();

pdRectangle.setLowerLeftX(...);
pdRectangle.setLowerLeftY(...);

pdRectangle.setUpperRightX(...);
pdRectangle.setUpperRightY(...);

link.setRectangle(pdRectangle);

page.getAnnotations().add(link);