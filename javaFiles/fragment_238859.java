@PostMapping("/posts")
    public @ResponseBody String add(@ModelAttribute("posts") Post p){

        postRepository.save(p);

        return "{msg : Resource added }";
    }