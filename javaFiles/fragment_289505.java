try {
    if (x>y)
        throw new NotFoundException("entity is not found");
} catch (NotFoundException e) {
    throw e;
} catch (Exception e) {
    throw new InternalServerErrorException(e);
}