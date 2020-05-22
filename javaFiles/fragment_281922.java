public class GenderConverter implements AttributeConverter<Gender, Character> {
    @Override
    public Character convertToDatabaseColumn(Gender from) {

        Character value = 'm';

        if (from == Gender.FEMALE) {
            value = 'f';
        }

        return value;
    }

    @Override
    public Gender convertToEntityAttribute(Character to) {
        Gender g = Gender.MALE;
        if ('f' == to)
            g = Gender.FEMALE;
        }
        return g;
    }
}