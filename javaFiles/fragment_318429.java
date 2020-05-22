public class MyImageCaptchaEngine extends ListImageCaptchaEngine {

@Override
protected void buildInitialFactories() {

    WordGenerator wgen = new RandomWordGenerator("ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789");
    RandomRangeColorGenerator cgen = new RandomRangeColorGenerator(new int[] { 0, 255 }, new int[] { 20, 100 }, new int[] { 20, 100 });

    TextPaster textPaster = new RandomTextPaster(new Integer(4), new Integer(5), cgen, Boolean.TRUE);

    BackgroundGenerator backgroundGenerator = new UniColorBackgroundGenerator(new Integer(240), new Integer(50), new Color(252,252,253));


    Font[] fontsList = new Font[] { new Font("Helvetica", Font.TYPE1_FONT, 10), new Font("Arial", 0, 14), new Font("Vardana", 0, 17), };

    FontGenerator fontGenerator = new RandomFontGenerator(new Integer(18), new Integer(30), fontsList);
    WordToImage wordToImage = new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster);
        this.addFactory(new GimpyFactory(wgen, wordToImage));
    }
}