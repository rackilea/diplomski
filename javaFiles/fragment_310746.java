@ResponseBody
@RequestMapping("/createform")
public String createform(Model uiModel, HttpServletRequest request) {
    //some other codes
    return "form";
}