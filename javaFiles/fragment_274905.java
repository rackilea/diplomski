switch(item.getItemId()){
        case R.id.update:
          String url = "http://sample.co.uk/sample.zip";
          new DownloadTask().execute( url );
            break;
    }
    return true;