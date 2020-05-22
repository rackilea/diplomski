CTSectPr getSectPr = document.getDocument().getBody().getSectPr();
getSectPr.unsetPgMar();
CTPageMar addNewPgMar = getSectPr.addNewPgMar();
addNewPgMar.setLeft(BigInteger.valueOf(720L));
addNewPgMar.setTop(BigInteger.valueOf(720L));
addNewPgMar.setRight(BigInteger.valueOf(720L));
addNewPgMar.setBottom(BigInteger.valueOf(720L));
// Also good to handle footer and header for more expectable result
addNewPgMar.setFooter(BigInteger.valueOf(0L));
addNewPgMar.setHeader(BigInteger.valueOf(0L));