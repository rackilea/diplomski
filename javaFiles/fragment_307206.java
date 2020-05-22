@RequestMapping(value="/viewcurrentpost")
public String showCurrentPost(Model m, Principal principal) {
    boolean hasPost = false;
    if(principal != null) {
        hasPost = postService.hasPost(principal.getName());
    }
   List<Post> posts = postDao.getCurrentPost(principal.getName());
           m.addAttribute("post", posts);
    m.addAttribute("hasPost", hasPost);

    return "viewcurrentpost";
}