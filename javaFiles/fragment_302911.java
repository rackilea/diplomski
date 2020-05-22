class RequestDTO<T> {}
class ResponseDTO<T> {}
class InstitutionDTO {}
class InstitutionRequestDTO extends RequestDTO<InstitutionDTO>
class InstitutionResponseDTO extends ResponseDTO<InstitutionDTO>

@RequestMapping(value = "/test/institution/", method = RequestMethod.POST)
public @ResponseBody InstitutionResponseDTO
    testPostREST(@RequestBody InstitutionRequestDTO institutionDTO) { }