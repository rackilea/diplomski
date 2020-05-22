@Service
public class GenericService {

    Entity1Service entity1Service;

    Entity2Service entity2Service;

    @Autowired
    public GenericService(Entity1Service entity1Service, Entity2Service entity2Service){
        this.entity1Service=entity1Service;
        this.entity2Service=entity2Service;
    }

    public GenericService(){

    }

     public void startEntityProcess(AbstractEntity entity) { 
        if (entity instance of Entity1)
            entity1Service.startEntity1Process(entity);
        else if (entity instance of Entity2)
            entity2Service.startEntity2Process(entity);
    }
}