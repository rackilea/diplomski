expectLastCall().andAnswer(new IAnswer() {
    public Object answer() {
        Assert.assertFail();
        return null;
    }
});