interface DevService
{
   void add(Device d);
   String getName();
}

@Service("devServiceLocal")
class DevServiceLocalImpl implements DevService
{
   void add(Device d) {...}
   String getName() {return "local";}
}

class Controller
{
   @Autowired
   Collection<DevService> services;

   void doSomethingWithService()
   {
      // TODO: Check type somehow
      String servType = "local";
      for(DevService s: services)
      {
         if(servType.equals(s.getName())
         {
            // Call service methods
            break;
         }
      }
   }
}