public interface ImCommandRepository
{
    Entity Get(int id);
    Entity Get(string name);
    void Save(Entity value);
    void Delete(int id);
}

public interface ImQueryRepository
{
    PaginatedResult<ViewModel> GetEntitiesA(int skip,int take);
    PaginatedResult<ViewModel> SearchEntitiesB(string keyword,int skip,int take);
}