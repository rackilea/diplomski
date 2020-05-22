public static void main(String[] args) {
    PrinterJob pj = PrinterJob.getPrinterJob();
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();
    // 10x15mm
    double width = cmsToPixel(10, 72);
    double height = cmsToPixel(15, 72);
    paper.setSize(width, height);
    // 10 mm border...
    paper.setImageableArea(
                    cmsToPixel(0.1, 72),
                    cmsToPixel(0.1, 72),
                    width - cmsToPixel(0.1, 72),
                    height - cmsToPixel(0.1, 72));
    // Orientation
    pf.setOrientation(PageFormat.PORTRAIT);
    pf.setPaper(paper);
    PageFormat validatePage = pj.validatePage(pf);
    pj.setPrintable(new Printable() {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            // Your code here
            return NO_SUCH_PAGE;
        }

    },  validatePage);
    try {
        pj.print();
    } catch (PrinterException ex) {
        ex.printStackTrace();
    }
}

// The number of CMs per Inch
public static final double CM_PER_INCH = 0.393700787d;
// The number of Inches per CMs
public static final double INCH_PER_CM = 2.545d;
// The number of Inches per mm's
public static final double INCH_PER_MM = 25.45d;

/**
 * Converts the given pixels to cm's based on the supplied DPI
 *
 * @param pixels
 * @param dpi
 * @return
 */
public static double pixelsToCms(double pixels, double dpi) {
    return inchesToCms(pixels / dpi);
}

/**
 * Converts the given cm's to pixels based on the supplied DPI
 *
 * @param cms
 * @param dpi
 * @return
 */
public static double cmsToPixel(double cms, double dpi) {
    return cmToInches(cms) * dpi;
}

/**
 * Converts the given cm's to inches
 *
 * @param cms
 * @return
 */
public static double cmToInches(double cms) {
    return cms * CM_PER_INCH;
}

/**
 * Converts the given inches to cm's
 *
 * @param inch
 * @return
 */
public static double inchesToCms(double inch) {
    return inch * INCH_PER_CM;
}