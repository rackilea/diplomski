import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import XopAwareMarshallingValidationEventHandler;
import XopAwareUnmarshallingValidationEventHandler;

public class XopAwareJaxb2Marshaller extends Jaxb2Marshaller {

  public XopAwareJaxb2Marshaller() {
    this.setMtomEnabled(true);
  }

  protected void initJaxbMarshaller(final Marshaller marshaller) throws JAXBException {
    super.initJaxbMarshaller(marshaller);

    marshaller.setEventHandler(new XopAwareMarshallingValidationEventHandler(marshaller.getEventHandler()));
  }

  protected void initJaxbUnmarshaller(final Unmarshaller unmarshaller) throws JAXBException {
    super.initJaxbUnmarshaller(unmarshaller);

    unmarshaller.setEventHandler(new XopAwareUnmarshallingValidationEventHandler(unmarshaller
        .getEventHandler()));
  }
}