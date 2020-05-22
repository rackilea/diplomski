Flux<User> users = userRepository.findAllByRole(Role.USER);
String emailBody = emailContentGenerator.createEmail();


// sendEmail() should return Mono<Void> to signal when the send operation is done
Mono<Void> sendEmailsOperation = users
     .flatMap(user -> sendEmail(user.getEmail(), emailBody, subject))
     .then();

// something else should subscribe to that reactive type,
// you could plug that as a return value of a Controller for example