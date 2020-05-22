class FahrenheitToCelsiusResponse {
    @XmlElement(name = "FahrenheitToCelsiusResult")
    private double result;

    public double getResult() {
        return result;
    }
}

public class X {

    public static void main(String[] args) throws Exception {
        String s = "<FahrenheitToCelsiusResponse><FahrenheitToCelsiusResult>32.2222222222222</FahrenheitToCelsiusResult></FahrenheitToCelsiusResponse>";
        FahrenheitToCelsiusResponse res = JAXB.unmarshal(new StringReader(s), FahrenheitToCelsiusResponse.class);
        System.out.println(res.getResult());
    }
}