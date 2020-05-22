@XStreamAlias("brands")
class Brands {
  @XStreamImplicit
  List<Brand> brand;
}

@XStreamAlias("brand")
class Brand {
  String nodeRef;
  String name;
}