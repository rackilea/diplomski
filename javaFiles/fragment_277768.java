@FeignClient(
  name = "calculatorServer", 
  url = "http://www.dneonline.com/calculator.asmx"
  configuration = MySoapClientConfiguration.class)
public interface AEMWebServiceFeignClient{

    @PostMapping(value = "", consumes = MediaType.TEXT_XML, produces = MediaType.TEXT_XML)
    AddResponse calculate(@RequestBody Add addRequest);

}