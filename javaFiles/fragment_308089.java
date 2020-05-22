private <T> T returnMeeting(List<T> meetingList, int id, Function<T,Integer> idGetter) {        
    return meetingList.parallelStream()
            .filter(m -> idGetter.apply(m).equals(id) )
            .findFirst()
            .get();
}