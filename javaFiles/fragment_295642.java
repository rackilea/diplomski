public class MainActivity extends Activity {

    private SocketContainer mSocketContainer;
    private final Object mSocketContainerLock = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // onClick attribute of one button.
    public void onClickPushMe(View view) {
        String serverAddress;
        int serverPort;
        new CreateSocketAsyncTask(serverAddress, serverPort).execute();
    }

    // onClick attribute of other button.
    public void onClickPushMeToo(View view) {
        String text;
        new WriteSocketAsyncTask(text).execute();
    }

    // Class that contains the socket and its streams,
    // so they can be passed from one thread to another.
    private class SocketContainer {

        private Socket mSocket;
        private InputStream mSocketInputStream;
        private OutputStream mSocketOutputStream;

        private SocketContainer(Socket socket, InputStream socketInputStream, OutputStream socketOutputStream) {
            mSocket = socket;
            mSocketInputStream = socketInputStream;
            mSocketOutputStream = socketOutputStream;
        }

        private Socket getSocket() {
            return mSocket;
        }

        private InputStream getSocketInputStream() {
            return mSocketInputStream;
        }

        private OutputStream getSocketOutputStream() {
            return mSocketOutputStream;
        }
    }

    // AsyncTask that creates a SocketContainer and sets in into MainActivity.
    private class CreateSocketAsyncTask extends AsyncTask<Void, Void, SocketContainer> {

        private final String mServerAddress;
        private final int mServerPort;

        private CreateSocketAsyncTask(String serverAddress, int serverPort) {
            mServerAddress = serverAddress;
            mServerPort = serverPort;
        }

        protected SocketContainer doInBackground(Void... params) {
            try {
                Socket socket = new Socket(mServerAddress, mServerPort);
                return new SocketContainer(socket, socket.getInputStream(), socket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected void onPostExecute(SocketContainer socketContainer) {
            super.onPostExecute(socketContainer);
            synchronized (mSocketContainerLock) {
                mSocketContainer = socketContainer;
            }
        }
    }

    private class WriteSocketAsyncTask extends AsyncTask<Void, Void, Void> {

        private final String mText;

        private WriteSocketAsyncTask(String text) {
            mText = text;
        }

        @Override
        protected Void doInBackground(Void... params) {
            synchronized (mSocketContainerLock) {
                try {
                    mSocketContainer.getSocketOutputStream().write(mText.getBytes(Charset.forName("UTF-8")));
                    mSocketContainer.getSocketOutputStream().flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return null;
        }
    }
}