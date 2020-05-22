public User findUser(Long id){

      if(id == null || id < 1){             
           throw new BadRequestException(ReflectionHelper.retrieveMethodAndClassName(), String.format(
                                         "Invalid Id: %d", id));
      }

      User user = userRepository.findOne(id);

      if(user == null){
           throw new DataNotFoundException(ReflectionHelper.retrieveMethodAndClassName(), String.format(
                                           "Can't Find User for Id: %d", id));
      }
      return user;
 }