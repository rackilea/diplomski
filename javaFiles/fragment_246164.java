public class ExampleSwitch extends Switch<Adapter> {

    public Adapter doSwitch(EObject eobject) {
        if (eobject instanceof MyModel) {
            switch (eobject.getType()) {
                case TYPEA:
                    Adapter result = createTypeAAdapter(eobject);
                    if (result == null) {
                        return createDefaultAdapter(eobject);
                    }
                    return result;
                case TYPEB:
                    ...
                default:
            }
        }
    } 
}