@SpringBootApplication
public class So44435897Application {

    public static void main(String[] args) {
        SpringApplication.run(So44435897Application.class, args);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface ApplicationUser { }

    @Component
    public static class CurrentUserBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            ReflectionUtils.doWithFields(bean.getClass(), field -> {
                ReflectionUtils.makeAccessible(field);
                if (field.getAnnotation(ApplicationUser.class) != null) {
                    final Object proxyInstance = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                            new Class[] { UserDetails.class }, (proxy, method, args) -> {
                                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                                if (authentication != null && authentication.isAuthenticated()) {
                                    final Object principal = authentication.getPrincipal();
                                    return method.invoke(principal, args);
                                }
                                throw new NullPointerException();
                            });
                    field.set(bean, proxyInstance);
                }
            });
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            return bean;
        }
    }

    @RestController
    public static class HomeController {
        final UserService userService;

        @Autowired
        public HomeController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public String me() {
            return userService.getName();
        }
    }

    @Service
    public static class UserService {
        @ApplicationUser
        UserDetails user;

        String getName() {
            return user.getUsername();
        }
    }
}