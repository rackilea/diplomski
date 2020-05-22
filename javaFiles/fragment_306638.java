public class Bridge {

    interface Callbacks {
        void onSomeResultComputed (Object result);
        void onSomeOtherResultComputed (Object result);
        // etc.
    }

    // Other methods and fields
}