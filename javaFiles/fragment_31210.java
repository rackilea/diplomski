@RequestMapping("/news/feed/featurednews/{feedname}")
public List<NewsModel> getFeed(String feedname, @RequestParam("start", optional) Integer startIndex) {
   return feedService.getFeaturedNewsByName(feedname);
}

@RequestMapping("/news/{newsPageName}")
public String goToNewsPage(Model m, String newsPageName) {
   m.addAttribute("stories", this.getFeed(newsPageName, 0));
   return getGenericNewsViewName();
}