class HatesTwos {
    boolean hates(int val) {
        return val == 2;
    }
}

HatesTwos hater = spy(new HatesTwos());

// let's capture the return values from hater.hates(int)
ResultCaptor<Boolean> hateResultCaptor = new ResultCaptor<>();
doAnswer(hateResultCaptor).when(hater).hates(anyInt());

hater.hates(1);
verify(hater, times(1)).hates(1);
assertFalse(hateResultCaptor.getResult());

reset(hater);

hater.hates(2);
verify(hater, times(1)).hates(2);
assertTrue(hateResultCaptor.getResult());