import com.sun.jna.*;
import com.sun.jna.ptr.PointerByReference;

import java.sql.Connection;

public class JNATest {
//    static {
//        System.loadLibrary("libspotify");
//    }

    public interface JLibspotify extends Library {
        int sp_session_create(sp_session_config config, PointerByReference sess);

        int sp_session_login(sp_session session, String username, String password);
        // All the other methods defined by the API
    }

    public static class sp_session extends PointerType {

        public sp_session(Pointer address) {
            super(address);
        }

        public sp_session() {
            super();
        }
    }

    public static class sp_session_config extends Structure {
        public int api_version = 7; // The version of the Spotify API your application is compiled with.
        public String cache_location = ".";
        public String settings_location = ".";
        public Pointer application_key; // Your application key.
        public int application_key_size; // The size of the application key in bytes
        public String user_agent = "jspotify";
        public sp_session_callbacks callbacks; // Delivery callbacks for session events. NULL if not interested in any callbacks
        public Pointer userdata; // User supplied data for your application
        public boolean compress_playlists;
        public boolean dont_save_metadata_for_playlists;
        public boolean initially_unload_playlists;
    }

    public interface LoggedIn extends Callback {
        public void logged_in(sp_session session, int error);
    }

    public interface LoggedOut extends Callback {
        public void logged_out(sp_session session, int error);
    }

    public interface ConnectionError extends Callback {
        public void connection_error(sp_session session, int error);
    }

    public static class sp_session_callbacks extends Structure implements Structure.ByReference{
    public LoggedIn logged_in; // Called when login has been processed and was successful
    public LoggedOut logged_out; // Called when logout has been processded. Either called explicitly if you initialize a logout operation, or implicitly if there is a permanent connection error.
    public Callback metadata_updated; // Called whenever metadata has been updated. If you have metadata cached outside of libspotify, you should purge your caches and fetch new versions.
    public ConnectionError connection_error; // Called when there is a connection error, and the library has problems reconnecting to the Spotify service. Could be called multiple times (as long as the problem is present)
    public Callback message_to_user; // Called when the acces point wants to display a message to the user. In the desktop client, these are shown in a blueish toolbar just below the search box.
    public Callback notify_main_thread; // Called when processing needs to take place on the main thread. You need to call sp_session_process_events() in the main thread to get libspotify to do more work. Failure to do so may cause request timeouts, or a lost connections.
    public Callback music_delivery; // Called when there is decompressed audio data available.
    public Callback play_token_lost; // Music has been paused because only one account may play music at the same time.
    public Callback log_message; // Logging callback
    public Callback end_of_track; // End of track. Called when the currently played track has reached its end.
    public Callback streaming_error; // Streaming error. Called when streaming cannot start or continue.
    public Callback userinfo_updated; // Called after user info (anything related to sp_user objects) have been updated.
    public Callback start_playback; // Called when audio playback should start. For this to work correctly the application must also implement get_audio_buffer_stats(). This function is called from an internal session thread - you need to have proper synchronization. This function must never block.
    public Callback stop_playback; // Called when audio playback should stop. For this to work correctly the application must also implement get_audio_buffer_stats(). This function is called from an internal session thread - you need to have proper synchronization. This function must never block.
    public Callback get_audio_buffer_stats; // Called to query application about its audio buffer. This function is called from an internal session thread - you need to have proper synchronization! This function must never block.
}

    private static final char[] APP_KEY ={/* Appkey here**/;

    public static void main(String[] args) throws InterruptedException {
        JLibspotify lib = (JLibspotify) Native.loadLibrary("spotify", JLibspotify.class);
        sp_session_config cfg = new sp_session_config();
        Pointer ptr = new Memory(APP_KEY.length);
        ptr.write(0, toBytes(APP_KEY), 0, APP_KEY.length);
        cfg.application_key = ptr;
        cfg.application_key_size = APP_KEY.length;
        sp_session_callbacks sessCallbacks = new sp_session_callbacks();
        LoggedIn loggedInCallback = new LoggedIn() {
            public void logged_in(sp_session session, int error) {
                System.out.println("logged_in() called");
            }

        };
        ConnectionError connectionErrorCallback = new ConnectionError() {

            public void connection_error(sp_session session, int error) {
                System.out.println("connection_error() called");
            }
        };
        LoggedOut loggedOutCallback = new LoggedOut() {

            public void logged_out(sp_session session, int error) {
                System.out.println("logged_out() called");
            }
        };

        sessCallbacks.logged_in = loggedInCallback;
        sessCallbacks.connection_error = connectionErrorCallback;
        sessCallbacks.logged_out = loggedOutCallback;
        sessCallbacks.log_message = new Callback() {
            public void callback(sp_session session, String message) {
                System.out.println("log_message() called:" + message);
            }
        };
        cfg.callbacks = sessCallbacks;
        PointerByReference sessionPbr = new PointerByReference();

        int error_id = lib.sp_session_create(cfg, sessionPbr); // CRASHES HERE
        System.out.println("sp_session_create returned " + error_id);
//
        sp_session mySession = new sp_session(sessionPbr.getValue());
        error_id = lib.sp_session_login(mySession, "foo", "bar");
        System.out.println("sp_session_login returned " + error_id);
        Thread.sleep(1000);
    }

    public static byte[] toBytes(char[] key){
        byte[] b = new byte[key.length];
        for(int i =0; i < key.length; i++){
            if(key[i] > 127){
                b[i] = (byte)(key[i] - 256);
            }else{
                b[i] = (byte)key[i];
            }
        }
        return b;
    }
}