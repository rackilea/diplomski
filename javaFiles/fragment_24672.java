@Service
@WebService
public class KPService {

    @Autowired
    CalculatorRemote calc;

    @WebMethod
    public int add(int a, int b){
        return calc.add(a, b);
    }


    @WebMethod
    public Result subtract(Input num){
         return calc.subtract(num);
    }

}