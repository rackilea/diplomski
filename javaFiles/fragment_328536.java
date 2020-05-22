Compiled from "SHA1HashFileAsyncTask.java"
public class de.dhbw.file.sha1.SHA1HashFileAsyncTask extends android.os.AsyncTas
k<java.lang.String, java.lang.Integer, java.lang.String> {
  [...]
  static {};
    Signature: ()V

  public de.dhbw.file.sha1.SHA1HashFileAsyncTask(android.content.Context, de.dhb
w.file.sha1.SHA1HashFileAsyncTask$SHA1AsyncTaskListener);
    Signature: (Landroid/content/Context;Lde/dhbw/file/sha1/SHA1HashFileAsyncTas
k$SHA1AsyncTaskListener;)V

  protected native void calcFileSha1(java.lang.String);
    Signature: (Ljava/lang/String;)V

  protected native int getProgress();
    Signature: ()I

  protected native void unlockMutex();
    Signature: ()V

  protected native java.lang.String getHash();
    Signature: ()Ljava/lang/String;

  [...]

  public void setFileSize(long);
    Signature: (J)V

  [...]
}