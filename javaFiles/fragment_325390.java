group.getGroupCallCenters().stream().forEach((existingGroupCall) ->
           {
               if(!existingGroupCall.getCallCenter()
              .getId().equals(accountCallCenterResource.getCallCenterId())) 
             {
               if 
              (!accountCallCenterResource.getValidity().getEffectiveStarting()
                    .isAfter(existingGroupCall.getExpirationDate())
                    && !existingGroupCall.getEffectiveDate()                      

       .isAfter(accountCallCenterResource.getValidity().getExpiresAfter())) 
                   {
               throw new ApiException(ApiErrorCode.DEFAULT_400, "Group call center already exist for that period");
                      }
           }
            else {
                throw new DuplicateException(ApiErrorCode.DUPLICATE, 
          existingGroupCall.getId());   
                }
            });