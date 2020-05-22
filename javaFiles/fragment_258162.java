package de.scrum_master.app;

public class UpdateRequester {
    public void doSomething() {
        throwMessage("http://my.url.org/foo", "my page");
    }

    private void throwMessage(String requestUrl, String page) {
        System.out.println("Throwing message for request " + requestUrl + " on page '" + page + "'");
    }
}