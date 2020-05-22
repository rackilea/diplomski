@Service
public class CompositeService {

    @Transactional
    public ResultBean compositeMethod() {
        ResultBean result = new ResultBean();
        result.setA(serviceA.getA());
        result.setB(serviceB.getB());
        return result;
    }
}