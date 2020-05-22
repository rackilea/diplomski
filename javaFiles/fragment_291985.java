import java.util.ArrayList;
import java.util.List;

public class NamesConverter {

    private List<String> titlesBefore = new ArrayList<>();
    private List<String> titlesAfter = new ArrayList<>();
    private String firstName = "";
    private String lastName = "";
    private List<String> middleNames = new ArrayList<>();

    public NamesConverter(String name) {
        String[] words = name.split(" ");
        boolean isTitleAfter = false;
        boolean isFirstName = false;

        int length = words.length;
        for (String word : words) {
            if (word.charAt(word.length() - 1) == '.') {
                if (isTitleAfter) {
                    titlesAfter.add(word);
                } else {
                    titlesBefore.add(word);
                }
            } else {
                isTitleAfter = true;
                if (isFirstName == false) {
                    firstName = word;
                    isFirstName = true;
                } else {
                    middleNames.add(word);
                }
            }
        }
        if (middleNames.size() > 0) {
            lastName = middleNames.get(middleNames.size() - 1);
            middleNames.remove(lastName);
        }
    }

    public List<String> getTitlesBefore() {
        return titlesBefore;
    }

    public List<String> getTitlesAfter() {
        return titlesAfter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    @Override
    public String toString() {
        String text = "Titles before :" + titlesBefore.toString() + "\n"
                + "First name :" + firstName + "\n"
                + "Middle names :" + middleNames.toString() + "\n"
                + "Last name :" + lastName + "\n"
                + "Titles after :" + titlesAfter.toString() + "\n";

        return text;
    }
}