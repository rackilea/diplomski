for (int i = startFrom; i < data.length(); i++){
        dataStorage = data.charAt(i);
          if(dataStorage != delim){
              dataValue = dataValue + dataStorage;
              i++;
          }