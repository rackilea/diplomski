Iterable<Book> findAllMyBooks(){
...
    List<String> roles = new ArrayList<>();
    Authentication authentication = SecurityContextHolder.getContext()getAuthentication();
    for (GrantedAuthority auth : authentication.getAuthorities()) {
        roles.add(auth.getAuthority());
    }
    bookRepository.findAllByRoles(roles);
...
}