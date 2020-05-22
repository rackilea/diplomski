Principal principal = request.getUserPrincipal();
if (principal != null) {
 logger.trace("User already authenticated");
 return true;
}

Realm realm = context.getRealm();

principal = realm.authenticate("user", (String) null);

register(request, response, principal, "Bearer", "user", null);

return true;