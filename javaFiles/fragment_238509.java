if(getData.isPresent()){
     if(updatedData.getHouseKeeping() == null ) {
        RoomBoy oldData = getData.get();

        oldData.setCondition(updatedData.getCondition());
        oldData.setStatus("Done");
        oldData.setHouseKeeping(today);

        roomBoyRepository.saveAndFlush(oldData);
        status.setStatusCode("000");
        status.setStatusDesc("Success");
    }else{
        RoomBoy oldData = getData.get();
        oldData.setCondition(updatedData.getCondition());

        roomBoyRepository.saveAndFlush(oldData);
        status.setStatusCode("000");
        status.setStatusDesc("Success");
    }
}
else{
        status.setStatusCode("001");
        status.setStatusDesc("Data Not Found");
}