public static void main(String[] args) throws IOException {
    String str = "https://www.amazon.es/MSI-Titan-GT73EVR-7RD-1027XES-Ordenador/dp/B078ZYX4R5/ref=sr_1_1?ie=UTF8&qid=1524239679&sr=8-1";
    extractReference(str).ifPresent(System.out::println);
    String html = "<div id =\" cerberus-data-metrics \"style =\" display: none; \"data-asin =\" B078ZYX4R5 \"data-as-price = \"1479.00\" data-asin-shipping = \"0\" data-asin-currency-code = \"EUR\" data-substitute-count = \"0\" data-device-type = \"WEB\" data-display-code = \"Asin is not eligible because it has a retail offer \"> </ div>";
    extractPrice(html).ifPresent(System.out::println);
}