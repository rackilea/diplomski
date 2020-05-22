driver.get("http://www.espncricinfo.com/indian-premier-league-2016/engine/match/981019.html");

    int i = 2;
    int rowNum = 0;
    while (true) {

        try {
            driver.findElement(
                    By.xpath(".//*[@id='full-scorecard']/div[2]/div/table[1]/tbody/tr[" + i + "]/td[2]/a"));

            i = i + 2;
            rowNum++;
        } catch (Exception e) {
            break;
        }

    }
    System.out.println("Total rows are : " + rowNum);