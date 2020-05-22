import java.util.Date;

public final class CreateOrder {
    private CreateOrder() {}

    public final class FormatUseByDate {
        private FormatUseByDate() {}

        public class Response {
            public Date date;

            @Override
            public Object clone() throws CloneNotSupportedException {
                Object cloned = super.clone();
                //...
                return cloned;
            }
        }

        public class Request {
            public Date date;

            @Override
            public Object clone() throws CloneNotSupportedException {
                Object cloned = super.clone();
                //...
                return cloned;
            }
        }

        public class ViewModel {
            String date;

            @Override
            public Object clone() throws CloneNotSupportedException {
                Object cloned = super.clone();
                //...
                return cloned;
            }
        }
    }
}