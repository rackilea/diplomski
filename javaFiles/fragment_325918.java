new AsyncTask<Void,Void,Void>(){

        @Override
        protected Void doInBackground(Void... params) {
            String modifiedSentence;
            BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
            Socket clientSocket = new Socket("192.168.1.91", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence = "connection with android successful";
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            clientSocket.close();

            return null;
        }

        @Override
        protected void onPostExecute() {
            super.onPostExecute();
            Button button=(Button) k;
            ((Button) k).setText("Done");
        }
    }.execute();