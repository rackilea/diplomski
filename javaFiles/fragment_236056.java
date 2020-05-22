@Service
class AClass implements MyService {

   @Autowired
   public AClass(UniqueInterface uniqueInterface) {
    ...
   }

   @Autowired
   @Qualifier("[beanName]")
   public void setAnInterface(NotUniqueInterface notUniqueInterface) {
      ...
   }
}