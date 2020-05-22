public class AssignIdToArticleAnswer implements Answer<Void> {

    private final Long id;

    public AssignIdToArticleAnswer(Long id) {
        this.id = id;
    }

    @Override
    public Void answer(InvocationOnMock invocation) throws Throwable {
        Article article = (Article) invocation.getArguments()[0];
        article.setId(id);
        return null;
    }
}