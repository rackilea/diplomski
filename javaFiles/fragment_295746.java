public void prepare() {     
        /* Prepare Async Task - starts buffering */
        try {           
            mediaPlayer.setDataSource(radioStreamURL);
            mediaPlayer.prepareAsync();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }