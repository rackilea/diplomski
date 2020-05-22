if (gotoURL == null || "".equals(gotoURL)) 
{
    final String errorMessage = "No Redirect URL Specified"; 
    modelMap.addAttribute("errorMessage ", errorMessage);
    return "loginerror";//loginerror is the view file I want to pass my error to.
}