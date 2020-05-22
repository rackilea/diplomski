enum Gender {
    MALE, FEMALE
}

class MyInfo {

    private Map<Gender, List<Person>> myInfo;

    public MyInfo(List<Person> females, List<Person> males) {
        myInfo = new HashMap<Gender, List<Person>>();
        myInfo.put(Gender.MALE, males);
        myInfo.put(Gender.FEMALE, females);
    }

    public Person get(Gender gender, int index) {
        myInfo.get(gender).get(index);
    }

}