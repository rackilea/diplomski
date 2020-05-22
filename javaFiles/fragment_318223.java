List listMock = EasyMock.createMock(List.class);

EasyMock.expect(listMock.isEmpty()).andAnswer(new IAnswer<Boolean>() {

    @Override
    public Boolean answer() throws Throwable {
        return true;
    }
});