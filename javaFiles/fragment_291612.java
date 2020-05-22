when(myMock.isContractAvailable(eq("0815"), argThat(new ArgumentMatcher<List<String>>() {
        @Override
        public boolean matches(List<String> list) {
            return "00123".equals(list.get(1)); // essentially ```list -> "00123".equals(list.get(1))``` in java 8
        }
})).thenReturn(true);