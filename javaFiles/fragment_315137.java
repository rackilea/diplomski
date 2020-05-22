public class HitPositionCollector implements Formatter
{
    // MatchOffset is a simple DTO
    private List<MatchOffset> matchList;
    public HitPositionCollector(
    {
        matchList = new ArrayList<MatchOffset>();
    }

    // this ie where the term start and end offset as well as the actual term is captured
    @Override
    public String highlightTerm(String originalText, TokenGroup tokenGroup)
    {
        if (tokenGroup.getTotalScore() <= 0)
        {
        }
        else
        {
            MatchOffset mo= new MatchOffset(tokenGroup.getToken(0).toString(), tokenGroup.getStartOffset(),tokenGroup.getEndOffset());
            getMatchList().add(mo);
        }

        return originalText;
    }

    /**
    * @return the matchList
    */
    public List<MatchOffset> getMatchList()
    {
        return matchList;
    }
}