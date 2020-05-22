Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, TARGET);
MyPageEventListener pageEventListener = new MyPageEventListener();
writer.setPageEvent(pageEventListener);
document.open();
[add all regular content to the document]
pageEventListener.lastPage = true;
document.close();