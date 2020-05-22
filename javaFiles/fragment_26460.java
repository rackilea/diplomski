import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonParserTest {

    static class ReponseJSON {
        private Response Response;

        @JsonProperty("Response")
        public Response getResponse() {
            return Response;
        }

        public void setResponse(Response Response) {
            this.Response = Response;
        }

        static class Response {
            private String rid;
            private Itm Itm;
            private List<Itm> listItm = new ArrayList<Itm>();

            public Itm getItm() {
                return Itm;
            }

            @JsonProperty("Itm")
            public void setItm(Itm Itm) {
                this.Itm = Itm;
                listItm.add(Itm);
            }

            public String getRID() {
                return rid;
            }

            public List<Itm> getItms() {
                return listItm;
            }

            @JsonProperty("RID")
            public void setRID(String rid) {
                this.rid = rid;
            }

            static class Itm {
                private Id id;

                private String qw, name;

                public String getQw() {
                    return qw;
                }

                public void setQw(String qw) {
                    this.qw = qw;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Id getId() {
                    return id;
                }

                public void setId(Id id) {
                    this.id = id;
                }

                static class Id {
                    private String ab, cd;

                    public String getCd() {
                        return cd;
                    }

                    public void setCd(String cd) {
                        this.cd = cd;
                    }

                    public String getAb() {
                        return ab;
                    }

                    public void setAb(String ab) {
                        this.ab = ab;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        String responseJson = 
        "{\"Response\":{\"RID\":\"04'34'\","
                + "\"Itm\":{\"id\":{\"ab\":\"1\",\"cd\":\"12\"},\"qw\":\"JK\",\"name\":\"abcd\"}"
                + ",\"Itm\":{\"id\":{\"ab\":\"2\",\"cd\":\"34\"},\"qw\":\"JK\",\"name\":\"asdf\"}"
                + ",\"Itm\":{\"id\":{\"ab\":\"3\",\"cd\":\"12\"},\"qw\":\"JK\",\"name\":\"fghj\"}"
                + "}} ";

        ObjectMapper mapper = new ObjectMapper();

        ReponseJSON responseObj = null;

        try {
            responseObj = mapper.readValue(responseJson, ReponseJSON.class);
            ReponseJSON.Response response = responseObj.getResponse();

            for(int i = 0; i < response.getItms().size(); i++)
            {
                ReponseJSON.Response.Itm item = response.getItms().get(i);

                System.out.println(item.getId().getAb());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}