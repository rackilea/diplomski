//Get the number of count in web table. 
WebElement table =d.findElement(By.xpath("//*[@id='ui-grid']/div/div/div/div[2]/table/tbody"));
            List<WebElement> trcount = table.findElements(By.tagName("tr"));
            int size = trcount.size();

            System.out.println(size);

            //Select particular  tag(Select tag)
            List<WebElement> Select = table.findElements(By.xpath("//*[@id='ui-grid']/div/div/div/div[2]/table/tbody/tr/td/span/select"));
            int select_size = Select.size();
            System.out.println(select_size);
            //If web table have select tag perfrom below else to catch no search elements exceptions. 
            try{
            for(int j=1;j<=select_size;j++) {
                By tag = By.xpath("(//*[@class='ng-star-inserted']/span/select)["+j+"]");
                System.out.println("Test");

             }
            }catch(Exception e){
                System.out.println((e.getMessage()));
            }
            //Select particular  tag(Input tag)
            List<WebElement> Select1 = table.findElements(By.xpath("//*[@id='ui-grid']/div/div/div/div[2]/table/tbody/tr/td/span/input"));
            int select_input = Select1.size();
            System.out.println(select_input);
            try{
            for(int i=1;i<=select_input;i++) {
                By tag1 = By.xpath("(//*[@class='ng-star-inserted']/span/input)["+i+"]");

                System.out.println("Test");

                d.findElement(tag1).sendKeys("12345");
                Thread.sleep(3000);
                //d.findElement(Accept_button).click();

            }
            }catch(Exception e){
                System.out.println((e.getMessage()));
            }