class IdentityRepository @Inject constructor() {

    @Inject
    @field:Named("NOT_AUTH_IDENTITY_SERVICE")
    lateinit var identityService: IdentityService
...
}