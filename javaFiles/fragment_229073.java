import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class Demo {

    public static void main(String[] args) {
        final AtomicBoolean done = new AtomicBoolean(false);
        Firebase ref = new Firebase("https://testjava.firebaseio-demo.com/");
        ref.setValue(new Date().toString(), new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                done.set(true);
            }
        });
        while (!done.get());
    }
}