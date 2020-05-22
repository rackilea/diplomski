public class Sample {

    Map<String, String> firstNameToLastName = new HashMap<>();
    private final Object nameMapLock = new Object();

    public String testMethod(String firstName) {
        synchronized(nameMapLock){
            String lastName = firstNameToLastName.get(firstName);

            if (lastName!= null)
                return lastName;

            String generateLastName = SomeAPI.generateLastName(firstName);

            firstNameToLastName.put(firstName, generateLastName);

            return generateLastName;
        }
    }
}