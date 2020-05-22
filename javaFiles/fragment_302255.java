public interface User<M extends Message> {
     public void in(M message);
}

public class WebsiteUser implements User<WebsiteMessage> {
     @Override
     public void in(WebsiteMessage message) {}
}