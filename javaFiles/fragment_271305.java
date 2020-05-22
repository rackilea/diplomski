private final PagedResourcesAssembler<User> pagedResourcesAssembler;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<PagedResources<UserResource>> list(Pageable pageable) {
        final Page<User> page = repository.findAll(pageable);
        final Link link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).list(null)).withSelfRel();

        PagedResources<UserResource> resources = page.getContent().isEmpty() ?
                (PagedResources<UserResource>) pagedResourcesAssembler.toEmptyResource(page, ShippingZoneResource.class, link)
                : pagedResourcesAssembler.toResource(page, resourceAssembler, link);

        return ResponseEntity.ok(resources);
    }