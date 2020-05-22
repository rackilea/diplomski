@Mapper
public interface PersonBioMapper {

  default PersonBio fileLineToPersonBio(String fileLine) {
    PersonBio personBio = new PersonBio();
    personBio.setBirthDate(new DateMapper().asDate(StringUtils.substring(fileLine,redactedpackagename.Constants.BIRTH_DATE_START_POS, redactedpackagename.Constants.BIRTH_DATE_END_POS)));

    return personBio;
  }
}