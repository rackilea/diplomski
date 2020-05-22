public static void createADomain() {
        DefaultCloudFoundryOperations cfOps= .... ;
        CreateDomainRequest createDomainRequest = CreateDomainRequest.builder()
                .domain("arunsample.company.com")
                .organization(ORG_NAME)
                .build();

        cfOps.domains().create(createDomainRequest).block();

        System.out.println("Domain Created successfully .. ");
    }