public class AssignedSequenceStyleGenerator 
    extends SequenceStyleGenerator {

    @Override
    public Serializable generate(SessionImplementor session, 
        Object obj) {
        if(obj instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) obj;
            Serializable id = identifiable.getId();
            if(id != null) {
                return id;
            }
        }
        return super.generate(session, obj);
    }
}