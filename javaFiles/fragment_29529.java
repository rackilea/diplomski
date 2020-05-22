rule "Multiple bookings via same mobile"
    when
        (stayDateGroupingIteration : StayDateGroupingDto($stayGroupedBookings : stayGroupedBookings)) and (QueryTypeDto( queryType == "multiple" ))
        $duplicateTravellerList :List() from accumulate(BookingSummaryDtoList( $bookingSummaryDtoList : bookingSummaryDtoList) from $stayGroupedBookings,
        init( int count=0; List<String> globalList= new ArrayList(); Set<String> duplicateSet=new HashSet(); List<String> finalDuplicateSet=new ArrayList();),
        action(
        for(Object bookingSummary : $bookingSummaryDtoList)
        {

            if(((BookingSummaryDto)bookingSummary).getTravellerId()!=null)
            {   
                String travellerId=((BookingSummaryDto)bookingSummary).getTravellerId().toString();
                finalDuplicateSet.add(MultiBookingFraudServiceImpl.checkDuplicates(travellerId,globalList,duplicateSet));
                count=count+1;
            }
        }
        ),
        result( new ArrayList(finalDuplicateSet)))
    then
        //some action to be taken here
        System.out.println($duplicateTravellerList);
end