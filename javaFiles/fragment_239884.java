public interface CategoryService {

    @IntAsID
    public int createNew(String languageCode, String name, String descriptionMarkdown, Integer parentCategoryID, String createdByUserName) throws ServiceException;

};