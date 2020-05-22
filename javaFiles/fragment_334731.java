import com.avada.rest.api.users.UserService;
import com.avada.rest.api.users.TestUserService;
import com.avada.rest.security.SpringAuthUser;

import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@ComponentScan(excludeFilters={
                @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=UserService.class)
              })
public class TestSpringRestConfig {

    public static final SpringAuthUser AUTH_USER =
        new SpringAuthUser("test", "test",
            new HashSet<GrantedAuthority>() {{
                add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }}
        );

    @Bean
    public UserService userService() {
        return new TestUserService();
    }

    @Bean
    public MockMvc mockMvc(WebApplicationContext wac) {
          return MockMvcBuilders
                 .webAppContextSetup(wac)
                 .defaultRequest(MockMvcRequestBuilders.get("/").with(SecurityMockMvcRequestPostProcessors.user(AUTH_USER)))
                 .apply(SecurityMockMvcConfigurers.springSecurity())
                 .build();
    }
}