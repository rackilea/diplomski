public class MyService{
@Autowired
private ServiceHelper serviceHelper;

@Transactional(propagation = **Propagation.REGUIRED_NEW**)
public void createWithCheck(){
   try{
      serviceHelper.tryConstraint();
   }catch(MyConstraintException e){
       serviceHelper.insertWithNoConflict();
   }
 }
}