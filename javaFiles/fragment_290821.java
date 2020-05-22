@Service
public class GenericService {
    @Autowired(required=false)
    Entity1Service entity1Service;

    @Autowired(required=false)
    Entity2Service entity2Service;

     public void startEntityProcess(AbstractEntity entity) { 
        if (entity instance of Entity1)
            entity1Service.startEntity1Process(entity);
        else if (entity instance of Entity2)
            entity2Service.startEntity2Process(entity);
    }
}