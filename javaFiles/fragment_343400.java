CompositeResponse.java

    public class CompositeResponse {

        @JacksonXmlProperty(localName = "CompositeIndividualResponse")
        @JacksonXmlElementWrapper(localName = "CompositeIndividualResponse",useWrapping = false)
        private List<CompositeIndividualResponse> compositeIndividualResponse;

        public List<CompositeIndividualResponse> getCompositeIndividualResponse() {
             return compositeIndividualResponse;
        }

       public void setCompositeIndividualResponse(List<CompositeIndividualResponse> compositeIndividualResponse) {
           this.compositeIndividualResponse = compositeIndividualResponse;
        }

    }

CompositeIndividualResponse.java: 

    public class CompositeIndividualResponse {

            @JacksonXmlProperty(localName = "PersonIdentification")
            private String personIdentification;

            public String getPersonIdentification() {
                return personIdentification;
            }
            public void setPersonIdentification (String personIdentification) {
              this.personIdentification= personIdentification; 
            }
    }

XMLToJson.java

    public class XMLToJson {
        public static void main(String[] args) throws IOException {
            String content = new String(Files.readAllBytes(Paths.get("test.xml")));
            XmlMapper xmlMapper = new XmlMapper();
            CompositeResponse poppy = xmlMapper.readValue(content, CompositeResponse.class);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(poppy);
            System.out.println(json);
        }
    }