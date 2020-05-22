try {
    if (x>y)
        throw new NotFoundException("entity is not found");
} catch (Exception e) {
    if (e instanceof NotFoundException) {
        throw e;
    } else {
        throw new InternalServerErrorException(e);
    }
}