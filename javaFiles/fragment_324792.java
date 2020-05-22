public boolean deleteLockStatus() {
    return Optional.ofNullable(jpaConnector.getMdssService())
        .flatMap(service -> {
            try {
                return Optional.ofNullable(service.deleteLockStatus());
            }
            catch(Exception e) {
                e.printStackTrace();
                return Optional.empty();
            }
        })
        .map(ServiceResponse::isError)
        .orElse(false);
}