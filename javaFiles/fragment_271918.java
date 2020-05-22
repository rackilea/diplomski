List<WebElement> allpages=d.findElements(By.xpath("//div[@id='reportPagination_wrapper']//a"));
    System.out.println("Total page : "+allpages.size());

    if(allpages.size()>0)
    {
        System.out.println("pagination exist");

        //click on pagination link

        for(int i=0;i<=allpages.size();i++)
        {
            allpages=d.findElements(By.xpath("//div[@id='reportPagination_wrapper']//a"));
            if(allpages.contains(flight_no))
            {
                System.out.println("record exists");

                break;
            }

            else
            {
                System.out.println("eleenmt no");
                allpages.get(i).click();
            }
          }               
      }

  }