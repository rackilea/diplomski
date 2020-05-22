import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class JaxbExample {
    public static void main(String[] args) throws JAXBException {
        String xml =
                "<Konduktors count=\"3\">\n" +
                "   <Konduktor>\n" +
                "      <id>29</id>\n" +
                "      <linie>S23</linie>\n" +
                "      <endstation>Langenthal</endstation>\n" +
                "      <station>Brugg AG</station>\n" +
                "      <zeit>17:36:34</zeit>\n" +
                "   </Konduktor>\n" +
                "   <Konduktor>\n" +
                "      <id>30</id>\n" +
                "      <linie>S23</linie>\n" +
                "      <endstation>Langenthal</endstation>\n" +
                "      <station>Lupfig</station>\n" +
                "      <zeit>17:37:12</zeit>\n" +
                "   </Konduktor>\n" +
                "   <Konduktor>\n" +
                "      <id>32</id>\n" +
                "      <linie>S23</linie>\n" +
                "      <endstation>Langenthal</endstation>\n" +
                "      <station>Birr</station>\n" +
                "      <zeit>16:23:30</zeit>\n" +
                "    </Konduktor>\n" +
                "</Konduktors>";
        Object object = JAXBContext.newInstance(Konduktors.class).createUnmarshaller().unmarshal(new StringReader(xml));
        System.out.println(object);
    }

    @XmlRootElement(name = "Konduktors")
    static class Konduktors {
        private List<Konductor> konductors = new ArrayList<Konductor>();

        @XmlElement(name = "Konduktor")
        public List<Konductor> getKonductors() {
            return konductors;
        }

        public void setKonductors(List<Konductor> konductors) {
            this.konductors = konductors;
        }

        @Override
        public String toString() {
            return "Konductors{" +
                    "konductors=" + konductors +
                    '}';
        }
    }

    static class Konductor {
        private int id;
        private String linie;
        private String endstation;
        private String zeit;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLinie() {
            return linie;
        }

        public void setLinie(String linie) {
            this.linie = linie;
        }

        public String getEndstation() {
            return endstation;
        }

        public void setEndstation(String endstation) {
            this.endstation = endstation;
        }

        public String getZeit() {
            return zeit;
        }

        public void setZeit(String zeit) {
            this.zeit = zeit;
        }

        @Override
        public String toString() {
            return "Konductor{" +
                    "id=" + id +
                    ", linie='" + linie + '\'' +
                    ", endstation='" + endstation + '\'' +
                    ", zeit='" + zeit + '\'' +
                    '}';
        }
    }
}