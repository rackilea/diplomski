@RequestMapping("/")
public String blog(Model model) {
    Sort sort = new Sort(Direction.DESC, "postId");
    model.addAttribute("posts",
            postViewRepository.findAll(new PageRequest(0, 5, sort))
                    .getContent());
    model.addAttribute("tease", true);
    return "blog/blog";
}