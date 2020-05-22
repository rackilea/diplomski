JacksonDataFormat jacksonDataFormat = new JacksonDataFormat();
jacksonDataFormat.setUnmarshalType(Contact.class);

from("direct:RetrieveContactRoute")
    .to("http://localhost:8080/api/contact/2345")
    .unmarshal(jacksonDataFormat);