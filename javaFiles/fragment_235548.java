import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseToken
import com.google.firebase.tasks.Task
import com.google.firebase.tasks.Tasks
import java.io.FileInputStream

class Firebase {
val options = FirebaseOptions.Builder()
    .setServiceAccount(
        FileInputStream("your/url/to/firebase.json")
    ).setDatabaseUrl("https://your-application.firebaseio.com")
    .build()

    fun validateToken(accessToken: String) {
        val firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.initializeApp(options))

        val authTask: Task<FirebaseToken> = firebaseAuth.verifyIdToken(accessToken)
        try{
            Tasks.await(authTask)
        } catch (e: Exception) {
            //handle exception
        }
        // retrieve uid/email/name
        authTask.getResult().uid
    }
}