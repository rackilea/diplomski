@Transactional
@Controller
@RequestMapping("/analysis")
public class Analysis {
@Resource
private VendorRepository vendorRepository;
@RequestMapping(value = "/vendors", method = RequestMethod.GET)
@ResponseBody
public String getVendors()
{
    List<Vendor> vendorList= vendorRepository.findAll();
    Hibernate.initialize(vendorList.get(0).getVedorTechnologies()); 
    return vendorList.get(0).getVedorTechnologies().get(0).getName();
}