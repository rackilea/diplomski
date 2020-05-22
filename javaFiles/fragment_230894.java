int i = 0;
    String[] project_text = new String[100];
    String[] actualVal = new String[100];

    while(isElementPresent(part1+i+part2)){     
        project_text[i] = driver.findElement(By.xpath(part1+i+part2)).getText();   
        assign_text = driver.findElement(By.xpath(assign_part1+i+assign_part2)).getText();
        if (assign_text.contains("aaaa"))
            System.out.println(project_text[i]);
        i++;
    }

    for(int j=0;j<droplist_cotents.size();j++){
        actualVal[j] = droplist_cotents.get(j).getText();  
        System.out.println(actualVal[j]);
    }

    for(int i = 0;i<project_text.length();i++)
        Assert.assertEquals(project_text[i], actualVal[i]);