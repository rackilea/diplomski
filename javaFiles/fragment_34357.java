public class Tickets {
    private Map<String, PeopleType> peopleTypes = new HashMap<>();

    @JsonAnySetter
    public void addPeopleType(String type, PeopleType peopleType) {
        peopleTypes.put(type, peopleType);
    }
}