public class MyClientServiceImpl {
    public static void main(String args[]){

    @Override
    public Integer add(int a , int b) {
       CalculatorService service = new CalculatorService();
       Calculator calculatorProxy = service.getCalculatorPort();            
        /**
         * Invoke the remote method
         */
        int result = calculatorProxy.add(10, 20);
        System.out.println("Sum of 10+20 = "+result);
    }
}