public ResponseEntity updatePassword(Password password) {
    Administrator administrator = administratorRepository.findAdministrator();
    if (passwordEncoder.matches(password.getOldPassword(), administrator.getPassword())) {
        String encodePassword = passwordEncoder.encode(password.getNewPassword());
        administrator.setPassword(encodePassword);
        administratorRepository.updateAdministrator(administrator);
        CustomUserDetailsService.password=encodePassword;
        return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
}