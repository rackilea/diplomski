import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjects {

    private final static ObjectMapper mapper = new ObjectMapper();

    private final static AlphaStatus as1 = new AlphaStatus();
    private final static AlphaStatus as2 = new AlphaStatus();

    static {
        as1.setAlphaHeaderKey("A");
        as1.setAlphaLineKey("B");

        as2.setAlphaHeaderKey("C");
        as2.setAlphaLineKey("D");
    }

    public static void main(String[] args) throws JsonProcessingException {

        final Gamma gamma = new Gamma();

        gamma.setAlphaStatuses(Arrays.asList(as1, as2));

        System.out.println(mapper.writeValueAsString(gamma));

        gamma.setAlphaStatuses(as1);

        System.out.println(mapper.writeValueAsString(gamma));

    }

    static class Gamma {

        Object alphaStatuses;

        public Object getAlphaStatuses() {
            return alphaStatuses;
        }

        public void setAlphaStatuses(Object alphaStatuses) {
            this.alphaStatuses = alphaStatuses;
        }
    }

    static class AlphaStatus {

        String alphaHeaderKey;
        String alphaLineKey;

        public String getAlphaHeaderKey() {
            return alphaHeaderKey;
        }

        public void setAlphaHeaderKey(String alphaHeaderKey) {
            this.alphaHeaderKey = alphaHeaderKey;
        }

        public String getAlphaLineKey() {
            return alphaLineKey;
        }

        public void setAlphaLineKey(String alphaLineKey) {
            this.alphaLineKey = alphaLineKey;
        }
    }
}