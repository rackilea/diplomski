public class ValidatingInterceptor extends PayloadValidatingInterceptor {
    @Override
    public QName getDetailElementName() {
        return new QName("http://www.mycee.co.za", "tech", "mt");
    }
}