@ReadingConverter
public class ContactReadConverter implements Converter<Document, Contact> {

    @Override
    public Contact convert(Document source) {
        if (source.get("firstName") == null) {
            Organisation organisation = new Organisation();
            I18n name = new I18n();
            name.setEn(source.get("name", Document.class).get("en", String.class));
            name.setFr(source.get("name", Document.class).get("fr", String.class));
            organisation.setName(name);
            organisation.setAcronym(source.get("acronym", String.class));
            organisation.setRole(source.get("role", String.class));
            return organisation;
        }
        Person person = new Person();
        person.setFirstName(source.get("firstName", String.class));
        person.setLastName(source.get("lastName", String.class));
        person.setRole(source.get("role", String.class));
        person.setEmail(source.get("email", String.class));
        person.setOrcId(source.get("orcId", String.class));
        if (source.get("organisation") != null) {
            Document sourceOrg = source.get("organisation", Document.class);
            Organisation organisation = new Organisation();
            organisation.setAcronym(sourceOrg.get("acronym", String.class));
            organisation.setRole(sourceOrg.get("role", String.class));
            if (sourceOrg.get("name") != null) {
                I18n name = new I18n();
                name.setFr(sourceOrg.get("name", Document.class).get("fr", String.class));
                name.setEn(sourceOrg.get("name", Document.class).get("en", String.class));
                organisation.setName(name);
            }
            person.setOrganisation(organisation);
        }
        return person;
    }
}