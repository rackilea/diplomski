public class Main {
    Bar[] array = new Bar[200];

    Optional<? super Bar> forIndex(int index) {
        return Optional.ofNullable(array[index]);
    }
}