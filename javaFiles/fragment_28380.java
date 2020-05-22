if (driver != null){
        if(healthCheck()){
            return driver;
        }
        driver = null;
    }