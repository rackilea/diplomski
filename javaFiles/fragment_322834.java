WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://goworkabit.com/tooampsud");
            Document doc = Jsoup.parse(driver.getPageSource());
            Elements jobs = doc.select("tr.c-workbites-table__workbites-row");
            for (Element job : jobs) {
                    System.out.print(job.select("td>a.c-workbites-table__workbites-title").text() +"    ,   ");
                    System.out.println(job.select("td.text-right").text());
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }