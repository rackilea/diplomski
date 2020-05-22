@PostMapping("")
    public Mono<User> login(@RequestBody User post,
                            @RequestParam String user_id,
                            @RequestParam String username,
                            @AuthenticationPrincipal CurrentUser currentUser) {

        //Need to access information from JWT claims here

        return this.repository.findById(user_id);
    }