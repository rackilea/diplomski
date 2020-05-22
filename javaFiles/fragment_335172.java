public class StartsWith <T extends String> implements Intaf<T> {

    @Override
    public boolean pres(T element, T argument) {

        String firstLetterElement = element.substring(0,1);

        String firstLetterArgument = argument.substring(0,1);

        return firstLetterElement.equals(firstLetterArgument);
    }
}