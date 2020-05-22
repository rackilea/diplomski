public UserDTO getUserFromAuthentication(JwtAuthenticationToken principal) {
        Map<String, Object> attributes = principal.getToken().getClaims();
        User user = getUser(attributes);
        Map<String, Object> resourceAccess = (Map<String, Object>) principal.getToken().getClaims().get("resource_access");
        JSONObject webApp = (JSONObject) resourceAccess.get("web_app");
        JSONArray roles = (JSONArray) webApp.get("roles");
        user.setAuthorities(roles.stream().map(authority -> {
            Authority auth = new Authority();
            auth.setName(authority.toString());
            return auth;
        }).collect(Collectors.toSet()));
        return new UserDTO(syncUserWithIdP(attributes, user));

    }