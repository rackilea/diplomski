@Entity
public class Article {

    @OneToMany(mappedBy="article")
    private Set<Keyword> keywords;

    //..

    public Set<Keyword> findKeywordsByArea(String area) {

        Set<Keyword> matchingKeywords = new HashSet<Keyword>();
        for(Keyword keyword : this.keywords) {
            if(keyword.getArea().equals(area)) {
                matchingKeywords.add(keyword);
            }
        }
        return matchingKeywords;
    }
}