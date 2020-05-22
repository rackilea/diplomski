@Configuration
public class Config extends AbstractMongoConfiguration {

    @Override
    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(mongoDbFactory(), mappingMongoConverter()) {

            @Override
            public IndexOperations indexOps(Class<?> entityClass) {

                return new DefaultIndexOperations(this, getCollectionName(entityClass), entityClass) {

                    @Override
                    public String ensureIndex(IndexDefinition indexDefinition) {

                        if(indexDefinition instanceof Index) {
                            ((Index)indexDefinition).background();
                        }

                        return super.ensureIndex(indexDefinition);
                    }
                };
            }
        };
    }

    // ...
}