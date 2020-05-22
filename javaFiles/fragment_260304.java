try{
                return getAudioFilesBasedOnCategories();
            }catch (RuntimeException e) {
                //log the error
                  throw e; // throw back
            }