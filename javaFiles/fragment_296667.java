public class Beneficiary {  
    private Type type; // enum: NGO, PUBLIC_ADMINISTRATION ..
    private Company company;
} 
public class Company {
    private String name;
    private String registrationNumber;
    private List<Person> agent;

    @PreSave
    public void preSave(BSONObject dbObj) {
        List<?> agents = (List<?>) dbObj.get("agents");
        for (int i = 0; i < agents.size(); i++) {
            if (Json.toJson(agents.get(i)).size() == 0) {
                agents.remove(i);
            }
        }

        if (agents.size() == 0) {
            dbObj.removeField("agents");
        }
        ....
    }
}
public class Person {
    private String name;
    private String email;
    private String phoneNumber;

    @PreSave
    public void preSave(BSONObject dbObj) {
        if (dbObj.get("name") != null && dbObj.get("name").equals("")) {
            dbObj.removeField("name");
        }
        ....
    }
}