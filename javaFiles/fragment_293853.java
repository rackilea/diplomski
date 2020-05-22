@RunWith(PowerMockRunner.class)
@PrepareForTest({GeocodingApi.class, GeocodingApiRequest.class})
public class GoogleApiServiceUnitTest  {

    private static final Double LATITUDE = -38.010403;
    private static final Double LONGITUDE = -57.558408;

    @Mock
    private GeoApiContext geoApiContext;

    @InjectMocks
    private GoogleApiService googleApiService;

    @Test
    public void testGetLocalityFromLatLng() throws Exception {

        LatLng latLng = new LatLng(LATITUDE, LONGITUDE);
        GeocodingResult geocodingResult = new GeocodingResult();
        geocodingResult.types = new AddressType[]{ AddressType.LOCALITY};
        geocodingResult.formattedAddress = "Some address";

        GeocodingResult[] geocodingResults = new GeocodingResult[] { geocodingResult };

        GeocodingApiRequest geocodingApiRequest = mock(GeocodingApiRequest.class);
        when(geocodingApiRequest.latlng(latLng)).thenReturn(geocodingApiRequest);
        when(geocodingApiRequest.await()).thenReturn(geocodingResults);

        mockStatic(GeocodingApi.class);

        when(GeocodingApi.newRequest(eq(geoApiContext)))
          .thenReturn(geocodingApiRequest);

        String locality = googleApiService.getLocalityFromLatLng(latLng);

        assertThat(locality, is(notNullValue()));

        verifyStatic(times(1));
        GeocodingApi.newRequest(geoApiContext);

        // add verification other mock if you really need it

        verifyNoMoreInteractions(geoApiContext);
    }
}