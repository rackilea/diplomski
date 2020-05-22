public static void main(String[] args) {

        WebDriver driver=new FirefoxDriver();

        driver.get("http://www.samsung.com/us/video/home-audio/all-products");

        List products = driver.findElements(By.className("product-image"));

        String pagination_no[]=driver.findElement(By.xpath("//*[@id='category_filter']/section/div[1]/div/div[1]/h1")).getText().split(" ");

        String[] pagination=pagination_no[1].split("-");

        Assert.assertEquals(Integer.parseInt(pagination[1]),products.size());       

       }
}