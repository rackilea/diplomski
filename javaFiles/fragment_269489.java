while ((count = input.read(data)) != -1) {
       if(!your_AsyncTask.isCancelled() &&  downloadstatus !=false){
        total += count;
        publishProgress("" + (int) ((total * 100) / lenghtOfFile));
        output.write(data, 0, count);
       }
      else{
             // free all resources here
            break;
        }
    }