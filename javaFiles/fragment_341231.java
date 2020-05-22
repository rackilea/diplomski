private int getIconResourceBasedOnMimeType(String mimeType) {
    switch (mimeType) {
        case MIMEType.TEXT_PLAIN:
            return R.drawable.ic_text_blue;
        case MIMEType.APPLICATION_PDF:
            return R.drawable.ic_pdf_blue;
        case MIMEType.APPLICATION_FLASH:
            return R.drawable.ic_swf_blue;
        case MIMEType.APPLICATION_DOC:
        case MIMEType.APPLICATION_DOCX:
            return R.drawable.ic_word_blue;
        case MIMEType.APPLICATION_XLS:
        case MIMEType.APPLICATION_XLSX:
            return R.drawable.ic_excel_blue;
        case MIMEType.APPLICATION_PPT:
        case MIMEType.APPLICATION_PPTX:
            return R.drawable.ic_pp_blue;
        case MIMEType.APPLICATION_OCTET_STREAM:
        default:
            return R.drawable.ic_binary_blue;
    }
}