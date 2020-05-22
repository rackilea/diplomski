public static ArticleHolder getJournalArticles(long groupId) 
    throws NumberFormatException, SystemException {

    List<JournalArticle> journalArticles = 
                JournalArticleLocalServiceUtil.getStructureArticles(groupId);
    List<String> allJournalArticleIds = new ArrayList<String>();

    for (JournalArticle journalArticle : journalArticles) {
        allJournalArticleIds.add(journalArticle.getArticleId());
    }

    return new ArticleHolder(journalArticles, allJournalArticleIds);
}