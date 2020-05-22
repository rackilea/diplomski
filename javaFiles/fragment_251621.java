NdefFormatable formatable = NdefFormatable.get(tag);

    if (formatable != null) {
      try {
        formatable.connect();

        try {
          formatable.format(message);
        }
        catch (Exception e) {
          // let the user know the tag refused to format
        }
      }
      catch (Exception e) {
        // let the user know the tag refused to connect
      }
      finally {
        formatable.close();
      }
    }
    else {
      // let the user know the tag cannot be formatted
    }