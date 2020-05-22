import org.krysalis.barcode4j.impl.pdf417.PDF417Bean

class TestController {
   def index = {

      def generator = new PDF417Bean()
      generator.height = 10

      def barcodeValue = "12345"
      renderBarcodePng(generator, barcodeValue)
   }
}