[Register ("com/google/android/youtube/player/YouTubePlayer", "", "Google.Android.Youtube.Player.IYouTubePlayerInvoker")]
public partial interface IYouTubePlayer : IJavaObject {

    bool HasNext {
        // Metadata.xml XPath method reference: path="/api/package[@name='com.google.android.youtube.player']/interface[@name='YouTubePlayer']/method[@name='hasNext' and count(parameter)=0]"
        [Register ("hasNext", "()Z", "GetHasNextHandler:Google.Android.Youtube.Player.IYouTubePlayerInvoker, Google.Android.Youtube.Player")] get;
    }

    bool HasPrevious {
        // Metadata.xml XPath method reference: path="/api/package[@name='com.google.android.youtube.player']/interface[@name='YouTubePlayer']/method[@name='hasPrevious' and count(parameter)=0]"
        [Register ("hasPrevious", "()Z", "GetHasPreviousHandler:Google.Android.Youtube.Player.IYouTubePlayerInvoker, Google.Android.Youtube.Player")] get;
    }

    bool IsPlaying {
        // Metadata.xml XPath method reference: path="/api/package[@name='com.google.android.youtube.player']/interface[@name='YouTubePlayer']/method[@name='isPlaying' and count(parameter)=0]"
        [Register ("isPlaying", "()Z", "GetIsPlayingHandler:Google.Android.Youtube.Player.IYouTubePlayerInvoker, Google.Android.Youtube.Player")] get;
    }

    // Metadata.xml XPath method reference: path="/api/package[@name='com.google.android.youtube.player']/interface[@name='YouTubePlayer']/method[@name='addFullscreenControlFlag' and count(parameter)=1 and parameter[1][@type='int']]"
    [Register ("addFullscreenControlFlag", "(I)V", "GetAddFullscreenControlFlag_IHandler:Google.Android.Youtube.Player.IYouTubePlayerInvoker, Google.Android.Youtube.Player")]
    void AddFullscreenControlFlag (int p0);

    // Metadata.xml XPath method reference: path="/api/package[@name='com.google.android.youtube.player']/interface[@name='YouTubePlayer']/method[@name='cuePlaylist' and count(parameter)=1 and parameter[1][@type='java.lang.String']]"
    [Register ("cuePlaylist", "(Ljava/lang/String;)V", "GetCuePlaylist_Ljava_lang_String_Handler:Google.Android.Youtube.Player.IYouTubePlayerInvoker, Google.Android.Youtube.Player")]
    void CuePlaylist (string p0);

    // Metadata.xml XPath method reference: path="/api/package[@name='com.google.android.youtube.player']/interface[@name='YouTubePlayer']/method[@name='cuePlaylist' and count(parameter)=3 and parameter[1][@type='java.lang.String'] and parameter[2][@type='int'] and parameter[3][@type='int']]"
    [Register ("cuePlaylist", "(Ljava/lang/String;II)V", "GetCuePlaylist_Ljava_lang_String_IIHandler:Google.Android.Youtube.Player.IYouTubePlayerInvoker, Google.Android.Youtube.Player")]
    void CuePlaylist (string p0, int p1, int p2);

    // Metadata.xml XPath method reference: path="/api/package[@name='com.google.android.youtube.player']/interface[@name='YouTubePlayer']/method[@name='cueVideo' and count(parameter)=1 and parameter[1][@type='java.lang.String']]"
    [Register ("cueVideo", "(Ljava/lang/String;)V", "GetCueVideo_Ljava_lang_String_Handler:Google.Android.Youtube.Player.IYouTubePlayerInvoker, Google.Android.Youtube.Player")]
    void CueVideo (string p0);