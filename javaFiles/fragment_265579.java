public class CustomNamingStrategy extends PropertyNamingStrategyBase {

    @Override
    public String translate(String propertyName) {

        // find a naming strategy here

        return propertyName;
    }

}

ObjectMapper om = new ObjectMapper();
Pojo myPojo = new Pojo(1, 10, new Content("string", "sid"));

om.setPropertyNamingStrategy(new CustomNamingStrategy());

  System.out.print(om.writerWithDefaultPrettyPrinter().writeValueAsString(myPojo));