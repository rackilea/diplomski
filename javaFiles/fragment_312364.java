@Service("authService")
public class AuthService implements UserDetailsService {

        @Autowired
        CustomUserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            CustomUser user = userRepository.findCustomUserByUserName(userName);

            return user;
        }

}