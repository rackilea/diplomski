public aspect ServletExceptionReporterAspect {

pointcut stringRequestHandler() : 
    execution (@RequestMapping String com.demo..*(ModelMap));

String around(ModelMap model): stringRequestHandler(){
    try {
        return proceed(model);
    } catch (Exception ex){
        System.out.println(model);
        return "myErrorView";
    }
}   
}