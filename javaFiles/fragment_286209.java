package test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Test {

    public static void main(String[] args) {
        try{
            JAXBContext jc = JAXBContext.newInstance(DataPacket.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File xml = new File("input2.xml");
            DataPacket dp = (DataPacket) unmarshaller.unmarshal(xml);
            Body body = dp.getBODY();
            ConsumerProfile profile = body.getProfile();
            ConsumerDetails consumerDetail = profile.getCONSUMER_DETAILS2();
            IdDetails idDetails = profile.getID_DETAILS2();
            System.out.println("ConsumerDetails name:"+consumerDetail.getNAME()+
                               " date of birth:"+consumerDetail.getDATE_OF_BIRTH()+
                               " gender:"+consumerDetail.getGENDER()+
                               "IdDetails SLNO:"+idDetails.getSLNO()+
                                " SOURCE_ID:"+idDetails.getSOURCE_ID()+
                                " ID_VALUE:"+idDetails.getID_VALUE()+
                                " EXP_DATE:"+idDetails.getEXP_DATE());
        }
        catch(JAXBException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}