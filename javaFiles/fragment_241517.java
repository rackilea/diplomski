@RequestMapping(method={RequestMethod.PUT}, value={"posts/{id}"})
public void updatePost(@PathVariable("id") Long id, HttpServletRequest request)
{
    //Fetch the authenticated user name
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    Object principal = authentication.getPrincipal();

    if (principal instanceof UserDetails) {
        username = ((UserDetails) principal).getUsername();
    }

    // Make a database call to verify if the user is owner of the post
    Post post = postRepository.getPostByUserName(String username, Long postId);

    if (post == null && !request.isUserInRole("ADMIN");) {
        //return 403 error code
    }

    //proceed with the update
}