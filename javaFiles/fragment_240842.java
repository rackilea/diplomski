import spock.lang.Shared
import spock.lang.Specification

class SnapClientTest extends Specification {

    @Shared def inputStream = new FileInputStream("../resources/keystore.bks")
    @Shared def keystorePwd = "password".toCharArray()
    @Shared def url = "https://example_webservice.com"

    def "Connect to https web service"() {
        setup:
        def snapzClient = new SnapzClient();

        expect: 
        snapzClient.makeRequest(A, B, C) == RESULT

        where:
        A           | B           | C   | RESULT
        inputStream | keystorePwd | url | "0"
    }
}