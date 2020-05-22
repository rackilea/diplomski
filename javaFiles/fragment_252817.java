@Controller
    @RequestMapping( value = "/walley/login", method = RequestMethod.POST)
    public void login(@RequestBody RequestDTO requestDTO,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServiceException {
              String userName = requestDTO.getUserName();
            String password = requestDTO.getPassword();
            System.out.println("userName " + userName +" :: password "+   password);}