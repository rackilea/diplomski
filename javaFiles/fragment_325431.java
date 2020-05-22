@Mapper
public interface EmailInfoMapper {

    EmailDTO entityToDTO(EmailEntity duration);
    EmailEntity dtoToEntity(EmailDTO price);

    DeliveredEmailInfoDTO entityToDTO(DeliveredEmailInfoEntity duration);
    DeliveredEmailInfoEntity dtoToEntity(DeliveredEmailInfoDTO price);
}