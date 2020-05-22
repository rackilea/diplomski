if(allUsersLoginInfo.stream().anyMatch(m -> m.getName().equals(loginInformation.getName())
                   || m.getRollNumber() == loginInformation.getRollNumber())){
        //exists
}else{
      // does not exist
}