@ChangeLog(order = "0.0.1")
public class MongoChangelogVersion_0_0_1 {

    @ChangeSet(order = "0001", id = "testSearchIndex", author = "djordje.ivanovic@****.com")
    public void dropIndex(MongoTemplate mongoTemplate) throws IOException {
        List<IndexInfo> indexes =  mongoTemplate.indexOps(TestSearch.class).getIndexInfo();
        for(IndexInfo indexInfo: indexes){
            if(indexInfo.getName().equals("idx_test_search")){
                mongoTemplate.indexOps(TestSearch.class).dropIndex("idx_test_search");
                break;
            }
        }
    }
}