@Test
public void partnerReIndexing_withPartnerEvent()throws Exception{
    Pageable page = CassandraPageRequest.of(0,5);
    when(partnerEventRepository.findAll(page)).thenReturn(new SliceImpl<>(Collections.EMPTY_LIST));
    // HERE COMES THE NEW LINE, THAT "ACT" PART OF THE TEST:
    partnerService.partnerReIndexing();
    verify(partnerEventRepository,times(1)).findAll(page);
}