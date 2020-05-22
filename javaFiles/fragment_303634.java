static <T> OngoingStubbing<T> whenX( Supplier<T> sup )
{    
    return Mockito.when( sup.get() );
}

whenX(thingsProvider::getThings).thenReturn(things);
// T = Iterable<? extends Thing>