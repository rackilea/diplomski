@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    // Read the file
    // Loop through all users and search for the given username
    // Return User or throw UsernameNotFoundException
    auth.userDetailsService(username -> {
            try {
                String pathToFile = // Path to file;
                List<String> users = Files.readAllLines(Paths.get(pathToFile));
                for (String user : users) {
                    String[] parts = user.split("\\s+", 2);
                    String theUsername = parts[0];
                    String password = parts[1];

                    if (username.equals(theUsername))
                        return new User(theUsername, password, Collections.singleton(new SimpleGrantedAuthority("USER")));
                }
                throw new UsernameNotFoundException("Invalid username");
            } catch (Exception e) {
                throw new UsernameNotFoundException("Invalid username");
            }
    });
}