links.forEach(new Consumer<WebElement>() {
    @Override
    public void accept(WebElement t) {
        System.out.println(t.getAttribute("href"));
    }
});