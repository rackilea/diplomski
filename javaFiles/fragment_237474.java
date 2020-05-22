userRepository.findOneById(id).map(user -> {
    UserDetails userDetails = user.getUserDetails();
    if (userDetails == null)
        userDetails = new UserDetails(user); 
     userDetails.setEmail(email);
     userDetailsRepository.save(userDetails);
});