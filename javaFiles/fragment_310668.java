//1.
public abstract class BaseController<E extends Entity> {

    @ModelAttribute("entity")
    public E populate(
            @RequestBody(required=false) E myEntity,
            @RequestHeader("X-Client-Name") String clientName) {
        if (myEntity != null) {
            myEntity.setCreatedBy(clientName);
        }
        return myEntity;
    }
}