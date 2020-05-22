public String LinkLocation(){
    WebElement link = driver.findElement(By.xpath("//*[@id='pagecontainer']/section/ul/li[1]/a"));
    String linkLocation = link.getAttribute("href");
    return linkLocation;
    }

public void actionPerformed(ActionEvent e) 
{
desk.browse(new URI(LinkLocation()));
}