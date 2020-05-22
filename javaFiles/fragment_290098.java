public interface StringRemove {

    public String remove(String input, String... subStringsToRemove);
}

public class StringReplaceAll implements StringRemove {

    public String remove(String input, String... subStringsToRemove) {
        for (int ix = 0; ix < subStringsToRemove.length; ix++) {
            input = input.replaceAll(subStringsToRemove[ix], "");
        }
        return input;
    }

}

public class StringReplace implements StringRemove {

    public String remove(String input, String... subStringsToRemove) {
        for (int ix = 0; ix < subStringsToRemove.length; ix++) {
            int replaceLength = 0;
            while (replaceLength != input.length()) {
                input = input.replace(subStringsToRemove[ix], "");
                replaceLength = input.length();
            }
        }
        return input;
    }

}

public class StringUtilsRemove implements StringRemove {

    public String remove(String input, String... subStringsToRemove) {
        for (int ix = 0; ix < subStringsToRemove.length; ix++) {
            input = StringUtils.remove(input, subStringsToRemove[ix]);
        }
        return input;
    }

}