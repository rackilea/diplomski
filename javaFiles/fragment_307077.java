public interface Verifier<T>{
   //definition
   public Err buildParaList(String value, Single<Parameter<?>> output);
}

public enum StringVerif implements Verifiier<String>{
    INSTANCE;
    //some static functions on my singleton
    @Override
    public Err buildParaList(String value, Single<Parameter<?>> output){
        output.elem = new Parameter<String>(value, INSTANCE);
        return Err.success();
    }
}
public abstract class ParamFactory{
    private static ArrayDeque<Verifier<?>> verifList...
    ...
    for(Verifier<?> ver : verifList){
        if(ver.isapplicable(someData){
            Single<Parameter<?>> param = new Single<Parameter<?>>();
            Err e = ver.buildParameter(value, param);
            //checks
            paramList.add(param.elem);
        }
    }
}