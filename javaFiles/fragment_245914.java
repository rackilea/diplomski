synchronized(IdManager.class){
          if (noOfUserIdsInReserveCurrently <= 20)
                  fetchIdsInReserve();    

          noOfUserIdsInReserveCurrently--;
      }