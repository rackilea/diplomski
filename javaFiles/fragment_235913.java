private boolean firstPage = true;

@Override
public void onEndPage(PdfWriter writer, Document document) {
    try {
        if (firstPage) {
            firstPage = false;
            addHeader(writer);
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    addFooter(writer);
}