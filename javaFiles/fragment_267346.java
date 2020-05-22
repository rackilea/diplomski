public class AccountController extends MultiActionController {

    @Autowired
    private Repository<Account, Integer> accountRepository;

    public AccountController() {
        /**
          * You can externalize this WebBindingInitializer if you want
          *
          * Here it goes as a anonymous inner class
          */
        setWebBindingInitializer(new WebBindingInitializer() {
            public void initBinder(WebDataBinder dataBinder, WebRequest request) {
                binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, numberFormat, true));
                binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
            }
        });
    }

    public ModelAndView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView()
                   .addAllObjects(
                       createBinder(request, new Command())
                      .getBindingResult().getModel())
                   .addObject(accountRepository.findById(Integer.valueOf(request.getParameter("accountId"))));
    }

}