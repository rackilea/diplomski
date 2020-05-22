public class Sentence {

    private TagList tags    
    private String category;
    private String sentence

    public Sentence(String newSentence) {
        sentence = newSentence;
        Extractor<TagList> e = new Extractor<TagList>()
        tags = e.extractTags(sentence);
        category = new Category(tags);
    }

    public String getXYZ() {

    }

    public void setXYZ(...) {...}

    private extractTags(String s){ ...}

    // getters, setters
}


public class TagList{

    private List<String> tags;

    ....
    //rest of class definition

}