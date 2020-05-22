ChromeDriver driver = new ChromeDriver();

driver.get("URL");

// locate the drop area
WebElement droparea = driver.findElement("file upload element");
Point point = droparea.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
// drop the file
DropFile(new File("location of file to be uploaded"), droparea, xcord ,ycord);


public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if(!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());

        WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver, 30);

        String JS_DROP_FILE =
            "var target = arguments[0]," +
            "    offsetX = arguments[1]," +
            "    offsetY = arguments[2]," +
            "    document = target.ownerDocument || document," +
            "    window = document.defaultView || window;" +
            "" +
            "var input = document.createElement('INPUT');" +
            "input.type = 'file';" +
            "input.style.display = 'none';" +
            "input.onchange = function () {" +
            "  var rect = target.getBoundingClientRect()," +
            "      x = rect.left + (offsetX || (rect.width >> 1))," +
            "      y = rect.top + (offsetY || (rect.height >> 1))," +
            "      dataTransfer = { files: this.files };" +
            "" +
            "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
            "    var evt = document.createEvent('MouseEvent');" +
            "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
            "    evt.dataTransfer = dataTransfer;" +
            "    target.dispatchEvent(evt);" +
            "  });" +
            "" +
            "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
            "};" +
            "document.body.appendChild(input);" +
            "return input;";

        WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        wait.until(ExpectedConditions.stalenessOf(input));
    }