@Test
    public void testIsTrafficIgnoredWhenAllOtherConditionsAreFalseButCheckIfShopIdFilterIsAppliedReturnsTrue() throws Exception {

        when( ellaConfiguration.isExternalCostumerFilter( environment ) ).thenReturn( false );
        when( ellaConfiguration.isInternalCostumerFilter( environment ) ).thenReturn( false );

        Set<Integer> shopIdsForTheOrders = new HashSet<>();

        shopIdsForTheOrders.add( 145 );
        shopIdsForTheOrders.add( 500 );
        shopIdsForTheOrders.add( SHOP_ID_FOR_ORDER );

        when( ellaFilterConfigHolder.getShopIdsToFilterSet() ).thenReturn( shopIdsForTheOrders );
        assertTrue( ellaService.isTrafficIgnored( validIrisBo ) );
    }