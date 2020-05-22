public class ModelException extends Exception{}

public class Step1ModelException extends ModelException{
    public Step1ModelException(List<String> details) {...}
    public List<String> getDetail(){...}
}

public class Step2ModelException extends ModelException{
    public Step2ModelException(List<String> details) {...}
    public List<String> getDetail(){...}
}

public class Step3ModelException extends ModelException{
    public Step3ModelException(Map<String,String> details) {...}
    public Map<String,String> getDetail(){...}
}