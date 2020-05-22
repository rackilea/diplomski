@Service
public interface ContentDocRepository extends CrudRepository<ContentDoc, String> {

    @View(viewName = "findContentByUser", designDocument="dev_content")
    public List<ContentDoc> findByContributors_id(String id) throws Exception;

}