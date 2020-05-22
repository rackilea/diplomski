@Service
public class PackageBaseServiceFactory {

    public final HashMap < String,
    PackageBaseService > packageBaseServiceCache = new HashMap();

    public PackageBaseService getPackageService() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            PackageBaseService packageBaseService = packageBaseServiceCache.get(authentication.getName());
            if (packageBaseService == null) {
                packageBaseService = initPackagesBaseService(authentication.getName());
            }
            return packageBaseService;
        }
    }

    private PackageBaseService initPackagesBaseService(String authenticationName) {
        PackageBaseService packageBaseService;
        if (authenticationName == env.getProperty("tableFactory.username")) {
            packageBaseService = new TablePackagesService();

        } else if (authenticationName == env.getProperty("deskFactory.username")) {
            packageBaseService = new DeskPackagesService();
        } else {
            throw new IllegalStateException(); //or whatever you do
        }
        return packageBaseServiceCache.put(authenticationName, packageBaseService);
    }
}