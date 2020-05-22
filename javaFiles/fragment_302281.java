public ModelAndView createIssueGet () {

    ModelAndView mav = new ModelAndView("/issues/CreateIssue");
    IssueTagEnvironment issuePackage = new IssueTagEnvironment();

    ModelAndView mav = new ModelAndView("/issues/CreateIssue");
    mav.addAttribute("issuePackage", issuePackage);

    [...]

    [...]
}