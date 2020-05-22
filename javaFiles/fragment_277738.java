void afterUnmarshal(Unmarshaller unm, Object parent) {
    localDateTime = ....
};
boolean beforeMarshal(Marshaller mar) {  
    date = localDateTime.toDate();
    ....
};