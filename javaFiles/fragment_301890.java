public class MyDAO {
    MyMapper mapper;

    public Article getArticle(int id) {
        try {
            return mapper.getArticle(id);
        } catch (PersistenceException e) {//IbatisException is deprecated
            throw ExceptionHandler.handle(e);
        }
    }
}