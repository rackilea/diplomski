public class StringVsStringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("one");
        String string = "two";

        try {
            builder.charAt(10); // Clearly out of bounds
        } catch (IndexOutOfBoundsException e) {
            System.out.println(String.format(
                    "Exception encountered accessing character out of index bounds on variable 'builder': %s",
                    e.getClass()
            ));
        }

        try {
            string.charAt(10); // Clearly out of bounds
        } catch (IndexOutOfBoundsException e) {
            System.out.println(String.format(
                    "Exception encountered accessing character out of index bounds on variable 'string': %s",
                    e.getClass()
            ));
        }
    }
}