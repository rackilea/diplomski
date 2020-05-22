@Autowired ProjectService projectService;

@GetMapping("/project/{slug_url}")
protected ResponseEntity getProject(@PathVariable("slug_url") String slugUrl) {
    return ResponseEntity.ok(projectService.findBySlugUrl(String slugUrl));
}