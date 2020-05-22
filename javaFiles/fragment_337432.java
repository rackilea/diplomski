public void update(List<Test> tests) {
    for (Test test : tests) {
        update(test);
    }
}

@PreAuthorize("hasPermission(#test, write) or hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
public void update(Test test) {
    testRepository.save(test);
    updateDeviceAcl(test);
}