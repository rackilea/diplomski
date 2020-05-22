String imageOutputPath = "the path to the folder that stores the screenshots";
if (driver.getTitle().contains("404"))
{
    takeScreenshotOfPage(driver, imageOutputPath + "404 error " + getDateTimeStamp() + ".png");
}
else if (some other error)
{
    takeScreenshotOfPage(driver, imageOutputPath + "some other error " + getDateTimeStamp() + ".png");
}
else if (yet another error)
{
    takeScreenshotOfPage(driver, imageOutputPath + "yet another error " + getDateTimeStamp() + ".png");
}