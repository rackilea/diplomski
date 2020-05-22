@NodeEntity
class CrowdFunding extends BaseEntity{
    String fundingFor
    String title

    @RelatedTo(type="HAS_USER")
    Collection<User> users
}