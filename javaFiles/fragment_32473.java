import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

// use this if CustomUser (principal) implements UserDetails
mvc
    .perform(get("/").with(user(principal)))
    ...

// otherwise use this
mvc
    .perform(get("/").with(authentication(auth)))
    ...