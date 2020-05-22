protected abstract Object getArgument(int ordem) {
     switch(ordem) {
     case 1: return login;
     case 2: return senha;
     case 3: return first_name;
     case 4: return last_name;
     case 5: return email;
     default: throw new IllegalArgumentException("Unknown ordem " + ordem);
     }
}