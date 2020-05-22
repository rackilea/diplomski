user.add(
    new Link(
         linkTo(UserController.class).slash("user").slash(user.getUsername())
            .toUriComponentsBuilder().build().toUriString() + "/",
         "Get User Details"
    )
);