public interface OnTaskCompleteListener { 
     void onTaskComplete(String result); 
}

protected void onPostExecute(String str) {
    onTaskCompleteListener.onTaskComplete(str);
}