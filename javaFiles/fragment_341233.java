driver.findElement(By.xpath(".//*[@class='PageRight']")).click();
        try {
            Thread.sleep(4000); //provide some time for the page to load before processing it
        } catch (InterruptedException ex) {
            Logger.getLogger(RealAuction.class.getName()).log(Level.SEVERE, null, ex);
        }