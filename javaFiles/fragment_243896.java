class TranslationCost
{
    private int id;
    private String sourceLang;
    private String targetLang;
    private float cost;
    private String comment;
}

Map<Integer, TranslationCost> idTocostMap;

public float calculateCost(int id, int countOfWords)
{
    TranslationCost costObj = idToCostMap.get(id);
    if (null == costObj) {
        // throw exception
    }
    return costObj.getCost() * countOfWords;
}