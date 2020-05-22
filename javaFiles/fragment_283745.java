public void setPageEvent(final PdfPageEvent event) {
    if (event == null) this.pageEvent = null;
    else if (this.pageEvent == null) this.pageEvent = event;
    else if (this.pageEvent instanceof PdfPageEventForwarder) ((PdfPageEventForwarder)this.pageEvent).addPageEvent(event);
    else {
        PdfPageEventForwarder forward = new PdfPageEventForwarder();
        forward.addPageEvent(this.pageEvent);
        forward.addPageEvent(event);
        this.pageEvent = forward;
    }
}