@Override
public void onPostExecute(String result)
{
     super.onPostExecute(result);
     if(mCallback!=null)
     {
      mCallback.Returnxml(result);
     } 
}