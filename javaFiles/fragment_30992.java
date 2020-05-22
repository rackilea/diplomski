import java.io.StringReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Deser {
    // @formatter:off

    private static final String JSON = "    <env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + 
            "    <env:Header></env:Header>\n" + 
            "    <env:Body>\n" + 
            "        <ns2:teste xmlns:ns2=\"http://teste.com.br/\">\n" + 
            "            <retorno>\n" + 
            "                <codigoRetorno>000</codigoRetorno>\n" + 
            "                <descricao>Consulta Realizada com Sucesso</descricao>\n" + 
            "                <item>\n" + 
            "                    <a>teste</a>\n" + 
            "                    <b>teste</b>\n" + 
            "                    <c>teste</c>\n" + 
            "                </item>\n" + 
            "                <item>\n" + 
            "                    <a>teste</a>\n" + 
            "                    <b>teste</b>\n" + 
            "                    <c>teste</c>\n" + 
            "                </item>\n" + 
            "            </retorno>\n" + 
            "        </ns2:teste >\n" + 
            "    </env:Body>\n" + 
            "</env:Envelope>";

    // @formatter:on

    private static final String TARGET_ELEMENT = "retorno";

    public static void main(String[] args) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        XMLInputFactory f = XMLInputFactory.newFactory();
        XMLStreamReader sr = f.createXMLStreamReader(new StringReader(JSON));

        while (sr.hasNext()) {
            int type = sr.next();

            if (type == XMLStreamReader.START_ELEMENT && TARGET_ELEMENT.equals(sr.getLocalName())) {
                Retorno r = xmlMapper.readValue(sr, Retorno.class);

                System.out.println(r.getDescricao());
            }
        }
    }
}

class Retorno {
    private int codigoRetorno;
    private String descricao;

    public int getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(int codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}