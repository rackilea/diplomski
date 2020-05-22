private void showPaperSize(ULocale locale) {
    PaperSize paperSize = LocaleData.getPaperSize(locale);
    String msg = MessageFormat.format("The paper size is: {0}x{1} mm",
            paperSize.getWidth(), paperSize.getHeight());
    System.out.println(msg);
}