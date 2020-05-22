ArgumentCaptor<Optional> captor =ArgumentCaptor.forClass(Optional.class)
verify(pojo).add(eq(key), captor.capture());

Optional<byte[]> result = captor.getValue();
assertTrue(result.isPresent());
assertArrayEquals(secondaryKey, result.get());