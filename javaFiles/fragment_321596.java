@PreAuthorize("hasAuthority('GET_USR')")
    @RequestMapping(value = "/min", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUserMinimalData() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User name " + auth.getName()); // prints - User name pratap
        System.out.println("User Authorities " + auth.getAuthorities()); // prints - User Authorities [ADMIN]
        return new ResponseEntity<>(this.facade.getUserMinimalData(), HttpStatus.OK);
    }