//import the Spring encoder
import org.springframework.security.crypto.password.PasswordEncoder;

@RequestMapping(value="/register", method=RequestMethod.POST)
public ModelAndView registerUser(ModelAndView modelAndView, User user) {

    // creating the instance class to use it
    private final PasswordEncoder passwordEncoder;

    User existingUser =userRepository.findByUserEmailIgnoreCase(user.getUserEmail());
    if(existingUser != null)
    {
        modelAndView.addObject("message","This email already exists!");
        modelAndView.setViewName("error");
    }
    else
    {  //encrypt the password here
       String encryptedPassword = passwordEncoder.encode(user.getPassword());
       user.setPassword(encryptedPassword);
       userRepository.save(user);