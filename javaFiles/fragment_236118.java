CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
 CTPageMar pageMar = sectPr.addNewPgMar();
 pageMar.setLeft(BigInteger.valueOf(720L));
 pageMar.setTop(BigInteger.valueOf(360L));
 pageMar.setRight(BigInteger.valueOf(720L));
 pageMar.setBottom(BigInteger.valueOf(360L));