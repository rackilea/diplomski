public class Processor {

    private Map<Class<? extends ObjTypeAbstract>, ProcessorInterface<? extends ObjTypeAbstract >> map = new HashMap<>();

    public Processor(){
        map.put(ObjType.class, new ObjProcessor());
        map.put(ScriptType.class, new ScriptProcessor());   
    }
    public void methodAbc(ObjTypeAbstract obj) {
        @SuppressWarnings("unchecked")
        ProcessorInterface<ObjTypeAbstract> processorInterface = (ProcessorInterface<ObjTypeAbstract>) map.get(obj.getClass());
        processorInterface.abcMethod(obj);
    }

}