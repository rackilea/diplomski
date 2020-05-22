List<WebElement> sections = driver.findElements(By.xpath("//*[@id='sections']/li/a"));
        System.out.println("sections: " + sections.size());
        for(int i=0;i<sections.size();i++){ 
            WebElement selement = sections.get(i);
            selement.click();
            List<WebElement> details = driver.findElements(By.xpath("//*[@id='details']/div/table/tbody/tr/td/table[1]/tbody/tr/td[2]/strong/a"));
            System.out.println("details: " + details.size());
            details.forEach(delement -> {
                url = delement.getAttribute("href");
                try {
                    huc = (HttpURLConnection) new URL(url).openConnection();
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    respCode = huc.getResponseCode();
                    if(respCode == 404) {
                        System.out.println(url + " link is broken");
                    } else if (respCode == 200) {
                        System.out.println(url + " link is ok");
                    } else {
                        System.out.println(url + " returned code " + respCode);
                    }
                    huc.disconnect();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            driver.navigate().back();
            sections = driver.findElements(By.xpath("//*[@id='sections']/li/a"));
        }