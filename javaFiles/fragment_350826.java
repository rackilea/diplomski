@RequestMapping(value = "/getcompanies", method = RequestMethod.POST)
    public CompaniesPresenter getCompanies(@RequestBody UserDetails user) {
        String OrgLoginId = user.getOrgLoginId();
        String password = user.getuPassword();
        String checkLoginId = null;
        String uPassword = null;
        String encPassword = null;
        String loginId = null;
        String checkAuthorized = null;
        //  String loginId=userService.getLoginId(OrgLoginId);
        List<Object[]> CheckIdPassword = userService.checkLoginId(OrgLoginId);
        List<Object[]> results = CheckIdPassword;
        for (Object[] obj : results) {
            checkLoginId = obj[0].toString();
            if (null == obj[1]) {
                uPassword = "";
            } else {
                uPassword = obj[1].toString();
            }
            loginId = obj[2].toString();
        }
        checkAuthorized = loginId.substring(0, 3);
        if (null != password) {
            MD5 md5 = new MD5();
            encPassword = md5.getPassword(password);
        }
        if (checkLoginId == null) {
            return new CompaniesPresenter("Incorrect loginId..Please enter valid loginId");

        } else if (encPassword.equals(uPassword)) {
            if (checkAuthorized.equals("STE")) {
                List<CompanyMaster> companyList = userService.getCompanyList(OrgLoginId);
                return new CompaniesPresenter(companyList,"success");
            } else {
                return new CompaniesPresenter("You are not Authorized");
            }
        } else {
            return new CompaniesPresenter("Incorrect Password");
        }