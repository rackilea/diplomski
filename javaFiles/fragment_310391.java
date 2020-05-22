try {

    ...

} catch (EOFException e) {
    throw new SQLException(e);
}