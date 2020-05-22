@Test(expected = ResponseStatusException.class)
public void test_Exception() {
    doThrow(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error", ex))
        .when(studentRepositoryMock).save(any());
    studentServiceImpl.saveStudent(studentDtoMock);
}