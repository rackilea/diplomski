@FeignClient(value = "APIBuscarCep", url = "${url}")
public interface BuscarCepFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "url-complement", produces = "application/json")
    CepResponseDTO getAddressByCep(@RequestHeader("Authorization") String token, @NotNull @PathVariable("cep") String cep);
}