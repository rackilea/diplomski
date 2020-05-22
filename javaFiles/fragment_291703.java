public void selectRegion(String param) {
    for (WebElement e : regions) {
        if (e.getText().equals(param)) {
            e.click();
            break;
        }
    }
}