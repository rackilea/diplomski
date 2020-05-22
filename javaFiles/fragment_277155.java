@PostMapping("/upload-model")
public Mono<String> processModel(@ModelAttribute Model model) {
    model.files.forEach(it -> it.transferTo(Paths.get("/tmp/" + it.filename())));
    return Mono.just("OK");
}

class Model {
    private List<FilePart> files;
    //getters and setters
}