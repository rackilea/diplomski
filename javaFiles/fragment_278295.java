ProfileEntity existingEntity = getById(ProfileEntity.get("key"));

        if(existingEntity == null)
            System.out.println("Invalid Profile Key");

        if(ProfileEntity.containsKey("firstName"))
            existingEntity.setFirstName(ProfileEntity.get("firstName"));

        if(ProfileEntity.containsKey("lastName"))
            existingEntity.setLastName(ProfileEntity.get("lastName"));

        if(ProfileEntity.containsKey("age"))
            existingEntity.setAge(ProfileEntity.get("age")));

        if(ProfileEntity.containsKey("mobile_Number"))
            existingEntity.setMobileNumber(ProfileEntity.get("mobile_Number"));

        super.save(existingEntity);