@Converter
public class AnomalieAckConverter implements AttributeConverter<AnomalieAck , Integer> {

 @Override
 public String convertToDatabaseColumn(AnomalieAck  anomalieAck ) {
   return anomalieAck.getValue();
 }

 @Override
 public AnomalieAck convertToEntityAttribute(Integer ack) {
    retrun AnomalieAck.getByValue(ack);
 }

}