public class CustomLayoutManager extends ClassicLayoutManager {

    protected void applyBanners() {
        super.applyBanners(); //let the ClassicLayoutManager apply header banners

        // explicitly add banner to footer band..
        JRDesignBand pageFooter = (JRDesignBand)getDesign().getPageFooter();

        // if there is no footer band we create one
        if(pageFooter == null) {
            pageFooter = new JRDesignBand();
            getDesign().setPageFooter(pageFooter);
        }

        Vector<ImageBanner> vImageBanner = new Vector<ImageBanner>();
        vImageBanner.add(new ImageBanner("yourlogoimage.ext", 120, 50, ImageBanner.ALIGN_LEFT));

        applyImageBannersToBand(pageFooter, vImageBanner, null);
    }
}