@Transactional
public Class BusinessService{

@resource
BusinessRepository businessRepository;

public Business getBusiness(){
  Business business = businessRepository.getBusiness();
  //Here you should initialize BusinessCategorySet
  Object object = business.getBusinessCategoriesSet().size();
  }
}