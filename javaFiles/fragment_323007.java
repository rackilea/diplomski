CTFtnEdn ctfInstance = CTFtnEdn.Factory.newInstance();

BigInteger id = new BigInteger("1");

ctfInstance.setId(id);

CTP ctp = ctfInstance.addNewP();

ctp.addNewPPr().addNewPStyle().setVal("FootnoteText");

CTR ctr = ctp.addNewR();
ctr.addNewRPr().addNewRStyle().setVal("FootnoteReference");
ctr.addNewFootnoteRef();

CTText cttext = ctp.addNewR().addNewT();
cttext.setStringValue("This is the text in the footnote");
cttext.setSpace(SpaceAttribute.Space.PRESERVE);