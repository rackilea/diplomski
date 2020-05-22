UserRepresentation userRepresentation = new UserRepresentation();
userRepresentation.setUsername("randomUser");
Response response = usersResource.create(userRepresentation);
logger.info("Response |  Status: {} | Status Info: {}", response.getStatus(), response.getStatusInfo());
String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
UserResource userResource = usersResource.get(userId);