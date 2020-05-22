@Component
public class MongoListener extends AbstractMongoEventListener<ImageDocument>
{

  private final MongoTemplate mongoTemplate;

  @Autowired
  public MongoListener(final MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public void onAfterSave(AfterSaveEvent<ImageDocument> event) {

    ImageDocument imageDocument = event.getSource();
    if(imageDocument.getData().getId() == null) {
      imageDocument.getData().setId(imageDocument.getId());
      mongoTemplate.save(imageDocument);
    }
  }
}