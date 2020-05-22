@Controller
class WebController {
   @PersistenceContext
   EntityManager em;

   @Autowired
   AsyncService service;

   @Transactional
   public Obj createObj(Obj obj){
        em.persist(obj);

        // Call the Async method only after transaction commit.
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {

           // Override the afterCommit which need to be executed after transaction commit
           public void afterCommit() { 
              //Run the time consuming async task for the newly-persisted entity
              service.runAsyncMethod(obj.getId());
           }
         }

        return obj;
      }

    }