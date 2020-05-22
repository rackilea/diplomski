for(GrantedAuthority currentAuth : authorities){
            if(currentAuth.getAuthority().equalsIgnoreCase("ROLE_USER")){
                isUser = true;
                break;
            }
            else {
                throw new IllegalStateException();
            }
        }