public void link(String line) throws InterruptedException { 

          System.out.println("Dosyadançekilenlerveriler: " + line);

            // driver.get("https://www.google.com/");
           driver.get(line);
             Thread.sleep(3000);     
        }