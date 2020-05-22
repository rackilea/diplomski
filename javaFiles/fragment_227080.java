public ModelAndView createFoo(@PathVariable long level1,
        @PathVariable long level2,
        @Valid @ModelAttribute() FooWrapper fooWrapper,
        BindingResult errors) {
  if (errors.hasErrors() {
     //handle errors, can just return if using Spring form:error tags.
  }
}

public static class FooWrapper {
  @NotNull
  @Size(max=32)
  private String fooName;
  private String description;
//getset
}