public class StringBuilderReplace {
        public static void main(String[] args) {
            StringBuilder builder = new StringBuilder();

            builder.append("Line 1\n");
            builder.append("Line 2\n");
            builder.append("Line 3\n");

            String lineToReplace = "Line 1\n";
            int startIndex = builder.indexOf(lineToReplace);
            int lastIndex = startIndex + lineToReplace.length();

            builder.replace(startIndex, lastIndex, "Temporary Line\n");
            System.out.println(builder.toString());
        }
}