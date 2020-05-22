@RequestMapping(value = "test")
  public @ResponseBody CompletableFuture<User> test(@RequestParam(value = "email", required = true) String email) throws InterruptedException {
        CompletableFuture<Boolean> boolean1= siteService.veryLongMethod();
        CompletableFuture<Boolean> boolean2= siteService.veryLongMethod();
        CompletableFuture<Boolean> boolean3= siteService.veryLongMethod();

        CompletableFuture.allOf(boolean1,boolean2,boolean3).join();
    return userService.findByEmail(email);
  }