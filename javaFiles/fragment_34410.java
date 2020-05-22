public class Story {
    public int index;
    public String text;
    public Choice[] choices;

    public Story(int index, String text, Choice[] choices) {
        this.index = index;
        this.text = text;
        this.choices = choices;
    }
}

public class Choice {
    public String text;
    public int leads_to_story;

    public Choice(String text, int leads_to_story) {
        this.text = text;
        this.leads_to_story = leads_to_story;
    }
}