@Autowired
PackageBaseServiceFactory packageBaseServiceFactory;

public MultiPackagesResponse data( @ RequestParam("fromId")int fromId) {
    MultiPackagesResponse response = packageBaseServiceFactory.getPackageService().getPackages(fromId);

    return response;
}