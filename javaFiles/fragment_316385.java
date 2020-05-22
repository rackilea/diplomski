import org.easymock.EasyMockSupport;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.expect;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigTest extends EasyMockSupport {
    // have your testClass extend EasyMockSupport, and use that to create your mock

    private ConfigService service;

    @Test
    public void testCallingService() {
        Config config=new Config(12345l);
        service = createMock(ConfigService.class);
        // as said before, use the createMock method you inherit
        config.setConfigService (service );
        expect(service.getId(12345l)).andReturn("mocked");
        expect(service.getId(17L)).andReturn("smaller");
        replayAll(); // don't forget the replayAll();
        String result = config.callingService();
        assertEquals( "mocked", result);
        Config config2 = new Config(17L);
        config2.setConfigService(service);
        String result2 = config2.callingService();
        assertEquals( "smaller", result2);
        verifyAll(); // to end your test which uses a mock
    }

    // Simple test without the mock to show the difference
    @Test
    public void testNonMocked() {
        Config config = new Config(50L);
        config.setConfigService(new ConfigService());
        String result = config.callingService();
        assertEquals("hardcoded", result);
    }
}