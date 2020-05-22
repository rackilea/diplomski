@Tag(name = SecurityOverrideCustomizer.UNSECURED)
    @GetMapping("/open")
    @ResponseBody
    public String open() {
        return "It works!";
    }