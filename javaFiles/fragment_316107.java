/**
* Runs on the UI thread before {@link #doInBackground}.
*
* @see #onPostExecute
* @see #doInBackground
*/
protected void onPreExecute() {
}

/**
* <p>Runs on the UI thread after {@link #doInBackground}. The
* specified result is the value returned by {@link #doInBackground}.</p>
*
* <p>This method won't be invoked if the task was cancelled.</p>
*
* @param result The result of the operation computed by {@link #doInBackground}.
*
* @see #onPreExecute
* @see #doInBackground
* @see #onCancelled(Object)
*/
@SuppressWarnings({"UnusedDeclaration"})
protected void onPostExecute(Result result) {
}