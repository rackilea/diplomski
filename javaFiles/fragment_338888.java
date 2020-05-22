class MyPageEventListener extends PdfPageEventHelper {
    public boolean lastPage = false;

    @Override
    public void onEndPage(PdfWriter writer, Document output) {
        if (!lastPage) {
            [add extra content for page before the last one]
        } else {
            [add extra content for last page]
        }
    }

    ...
}