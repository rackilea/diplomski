try {
        source = new FileInputStream(currentDB).getChannel();
        (new File(backupDB.getParent())).mkdirs(); //<<<<<<<<<<<<<< ADDED
        destination = new FileOutputStream(backupDB).getChannel();
        //destination.transferFrom(source, 0, source.size());
        source.close();
        destination.close();
    } catch(IOException e) {
        e.printStackTrace();
        Toast.makeText(this, "Err:"+e, Toast.LENGTH_LONG).show();
    }