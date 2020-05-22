@Component
public class Validator {

   @Autowired
   private Service service;

    public boolean doTrickyValidation(HashMap<String, Object> itemsMap, Object dependentObject) {
        // resolve the validation strategy from the items passed to this method.

        TrickyValidation validation = resolveTrickyValidation(itemsPam, dependentObject);

        return validation.validate();
    }

    private TrickyValidation resolveTrickyValidation(...) {
      // construct the proper validation strategy
      // access service if you want
    }



}