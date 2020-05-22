@Mapper(imports = {DateMapper.class, StringUtils.class})
public interface PersonBioMapper {

  @Mapping(target = "birthDate",
      expression = "java(new DateMapper().asDate(StringUtils.substring(fileLine, redactedpackagename.Constants.BIRTH_DATE_START_POS, redatcedpackagename.Constants.BIRTH_DATE_END_POS)))")
  PersonBio fileLineToPersonBio(String fileLine);
}