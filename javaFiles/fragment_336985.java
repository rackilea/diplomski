@GetMapping("/buscarPorFiltros")
@Consumes(MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ProjetoResponse> buscarPorFiltros(String pesquisa ){
    try {
        String result = java.net.URLDecoder.decode(pesquisa, StandardCharsets.UTF_8.name());
        ObjectMapper mapper = new ObjectMapper();
        PesquisaDTO pesquisaDto = mapper.readValue(result, PesquisaDTO.class);