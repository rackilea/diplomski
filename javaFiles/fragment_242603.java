public class DataRequest {
    private Integer value1;
    private Integer value2;

    public Integer getValue1() {
        return value1;
    }

    public void setValue1(Integer value1) {
        this.value1 = value1;
    }

    public Integer getValue2() {
        return Value2;
    }

    public void setValue2(Integer value2) {
        Value2 = value2;
    }
}

@RequestMapping(value = "/addNumber", method = RequestMethod.POST)
@ResponseBody
public String controllerMethod(@RequestBody DataRequest request){
    Integer value1 = request.getValue1();
    Integer value2 = request.getValue2();
    System.out.println("values :"+value1+" , "+value2);
    int result=value1+value2;
    System.out.println(result);
    String res=Integer.toString(result);
    return res;
}