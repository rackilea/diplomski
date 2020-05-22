String result = record.accept(new RecordTypeVisitor<String>() {

    String visitOne(RecordType1 recordType) {
        //processing of RecordType1
        return "Jeden";
    }

    String visitTwo(RecordType2 recordType) {
        //processing of RecordType2
        return "Dwa";
    }

});