@Autowired  
@Qualifier(name="homeBankingDaoImpl")
HomeBankingDao homeBankingDao;
@RequestMapping(value="/login",method=RequestMethod.GET)
public String login(ModelMap model){
    System.out.println("###########################");
    model.addAttribute("signup",new Signup());
    return "login";
}