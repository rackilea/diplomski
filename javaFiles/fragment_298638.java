ClassUnderTest sut = spy(new ClassUnderTest(...));

sut.doSomethingWithInputs(Arrays.asList(entry1, entry2, entry3));

verify(sut).handleAInput(entry1);
verify(sut).handleAInput(entry2);
verify(sut).handleBInput(entry3);
verifyNoMoreInteractions(sut); // if necessary