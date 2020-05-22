public class Sample {

    ConcurrentHashMap<String, String> firstNameToLastName = new ConcurrentHashMap<>();

    public String testMethod(String firstName) {
        return firstNameToLastName.computeIfAbsent(firstName, 
                    name -> SomeAPI.generateLastName(name));

        }
    }
}