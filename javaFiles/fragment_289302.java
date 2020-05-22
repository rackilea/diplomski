@Override
   @JsonIgnore  //Tell Jackson to ignore this metod, you can use @XMLTransient
   public Collection<? extends GrantedAuthority> getAuthorities() {
       Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
       if (getRole() != null) {
        for (Right right : getRole().getRights()) {
          GrantedAuthority authority = new GrantedAuthority(right.getName());
          authorities.add(authority);
        }
     }
     return authorities;
   }