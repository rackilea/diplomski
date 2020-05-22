@PostMapping
    @Validated(OnRegistrationRequest.class) // this one is "@Valid" with a specified group and will be used for return value validation
    @ResponseStatus(HttpStatus.CREATED)
    public KidDTO createKidRegistration(@RequestBody @Valid /* this one is for method parameter */ KidDTO kid) {
        return kidService.saveKid(kid);
    }