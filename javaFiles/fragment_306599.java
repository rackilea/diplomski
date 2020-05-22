public class Test {

    public static void main(String[] args) throws AxisFault,Exception {

        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();

        String [] vendors = {"http://example.com/vendor1/services/GETWeatherHttpSoap12Endpoint", "http://example.com/vendor2/services/GETWeatherHttpSoap12Endpoint"}; // Array of all vendors

        for (String vendor : vendors) {
            EndpointReference targetEPR = new EndpointReference(vendor);
            options.setTo(targetEPR);
            QName opGetExchange = new QName("http://ws.apache.org/axis2", "getWeather");

            // preparing the parameters
            String country = "USA";
            Object[] opGetExchangeArgs = new Object[] {country};

            // preparing the return type
            Class[] returnTypes = new Class[] { String.class };

            // invoking the service passing in the arguments and getting the response
            Object[] response = serviceClient.invokeBlocking(opGetExchange, opGetExchangeArgs, returnTypes);
            // obtaining the data from the response
            String result = (String) response[0];

            System.out.println("Vendor: " + result);
        }
    }
}