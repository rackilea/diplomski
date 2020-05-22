for (Iterator<TestDTO> it = test.iterator(); it.hasNext();) {
    TestDTO currentTestDTO = it.next();
    if (!(duplicate.contains(currentTestDTO.getOne()))) {
        System.out.println(currentTestDTO.getOne());
        it.remove();
    }
}