public class GenderFormatter implements Formatter<Gender>{

@Override
public String print(Gender gender, Locale local) {
    return gender.getLabel();
}

@Override
public Gender parse(String value, Locale local) throws ParseException {
    if(Gender.valueOf(value) == Gender.MALE) {
        return Gender.MALE;
    } else {
        return Gender.FEMALE;
    }
}