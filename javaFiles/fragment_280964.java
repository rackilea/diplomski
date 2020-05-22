AppleTree appleTree = Mockito.mock(AppleTree.class);
Apple apple = Mockito.mock(Apple.class);

Seed seed  = new Seed();

Mockito.when(appleTree.getApple()).thenReturn(apple);
Mockito.when(apple.getSeed()).thenReturn(seed);

Seed actual = getAppleSeed(appleTree);

assertThat(actual, is(seed));