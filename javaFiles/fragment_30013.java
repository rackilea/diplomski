public interface newInterface {
    default void exampleTwoMethod(int number) {
        while (userChoice.getNumber(number) == 0) {
            number--
        }
        option = false;
    }

    default void exampleOneMethod(int number) {
        userChoice = choice - 2;
        while (userChoice.getNumber(number) == 0) {
            number--
        }
        option = false;
        }
    }
}