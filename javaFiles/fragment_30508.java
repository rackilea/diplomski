@RestController
public class SomeAPI {
    private SomeCrudRepository repository;


    @Autowired
    public SomeAPI(SomeCrudRepository repository) {
        Assert.notNull(repository);
        this.repository = repository;
    }

    @RequestMapping(value = "/complicated-change-something", method = RequestMethod.POST)
    @Transactional
    public Thing changeData(Thing someEntry, SomeJson changes) throws JsonProcessingException {
        ThingEntity metadataEntity = repository.getMetadata(someEntry.getEntityID(), someEntry.getSomethingElse());

        if (cond1) {
            if (cond2) {
                //get all db entries that might change
                List<ThingEntity> metadataEntries = repository.getThings(someEntry.getEntityID(), something);

                   ThingEntity entityBefore = metadataEntries.get(0);

                    ThingEntity newEntity = new ThingEntity(entityBefore);

                    newEntity.setChangedData(data);

                    repository.delete(entityBefore);

                    entityBefore = repository.save(newEntity);

            }

            //set current entry
            ThingEntity newEntity = new ThingEntity(metadataEntity);
            newEntity.setChangedData(data);

            repository.delete(metadataEntity);
            metadataEntity = repository.save(newEntity);
        }
...
...

        return metadataEntity.toThing();
    }

}