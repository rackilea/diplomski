Component
public class IdentifierListener extends AbstractMongoEventListener<A> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<A> event){
        if(event.getSource().getId() == null){
            B id = new B();
            id.setId(new ObjectId());
            event.getSource().setId(id);
        }
    }
}