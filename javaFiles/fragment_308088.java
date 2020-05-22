interface IdProvider {
   int getId();
}

private <T extends IdProvider> T returnMeeting(List<T> meetingList, int id)    {        
    return meetingList.parallelStream()
            .filter(m -> m.getId() == id )
            .findFirst()
            .get();
}