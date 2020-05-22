@Secured({"ROLE_PROJECTADMIN", "ROLE_API", "ROLE_STUDENT", "ROLE_TEACHER", "ROLE_ADMIN"})
    @GetMapping("content/asset/all")
    @ResponseBody
    private List<ContentCategory> getAllContentCategory(HttpServletRequest request) {
        log.info("Request: " + request.getUserPrincipal().getName());

        return contentCategoryService.getContentCategoriesByUser(request.getUserPrincipal().getName());
    }