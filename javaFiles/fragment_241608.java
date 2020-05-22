@RequestMapping(value ="support",method = RequestMethod.GET)
 public String support(Model model){

    model.addAttribute("listBannerWeb", getBannerList());

    return "menu/support";
 }

@RequestMapping(value ="news",method = RequestMethod.GET)
public String news(Model model){

    model.addAttribute("listBannerWeb", getBannerList());

    return "menu/news";
 }

private List<Banner> getBannerList() {

    Banner banner = new Banner();
    List<Banner> listBannerWeb = bannerService.getBannerList(banner); 
    return listBannerWeb;
}