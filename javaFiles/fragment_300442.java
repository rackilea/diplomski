package stackoverflow35769423;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import stackoverflow35769423.jaxb.ObjectFactory;
import stackoverflow35769423.jaxb.Output;
import stackoverflow35769423.jaxb.ResultType;

public class CreateResultFile {

    public static void main(String[] args) {    
        try {
            (new CreateResultFile()).writeFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void writeFile() throws JAXBException, FileNotFoundException {  
        OutputStream os = new FileOutputStream("files" + File.separator + "output.xml");
        ObjectFactory factory = new ObjectFactory();
        JAXBContext jaxbContext = JAXBContext.newInstance(factory.getClass().getPackage().getName());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Output output = factory.createOutput();
        output.setOption("abc");
        output.setRefid("8789");

        Output.Response reponse = factory.createOutputResponse();
        reponse.setResponsecode("1234");
        reponse.setResponsedetails("xyz");
        output.setResponse(reponse);

        Output.Result result = factory.createOutputResult();
        ResultType resultFront = factory.createResultType();
        resultFront.setContainimage("Yes");
        resultFront.setContaindetail("No");

        ResultType resultBack = factory.createResultType();
        resultBack.setContainimage("Yes");
        resultBack.setContaindetail("Yes");

        result.setFront(resultFront);
        result.setBack(resultBack);
        output.setResult(result);

        jaxbMarshaller.marshal(output, os);
    }
}