public interface MyMapper {

    default Boolean map(ChoiceType value) {
        if (value == null) {
            return null;
        }

        switch(value) {
            case YES:
                return true;
            case NO:
            default:
                return false;
        }
    }
}