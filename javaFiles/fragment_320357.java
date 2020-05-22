@RequestMapping("/posts")
public String showAllPosts(ModelMap model) {

    List<Post> posts = postDao.findAll();
    model.addAttribute("post", new Post()); // Add empty form backing object
    model.addAttribute("posts", posts);
    return "posts";
}