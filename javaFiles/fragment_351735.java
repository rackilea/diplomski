public class DownloadPDFTask extends AsyncTask<String, Void, Integer> 
{
    protected ProgressDialog mWorkingDialog;    // progress dialog
    protected String mFileName;         // downloaded file
    protected String mError;            // for errors

    @Override
    protected Integer doInBackground(String... urls)
    {

     try
     {
      byte[] dataBuffer = new byte[4096];
          int nRead = 0;

          // set local filename to last part of URL
          String[] strURLParts = urls[0].split("/");
          if (strURLParts.length > 0)
            mFileName = strURLParts[strURLParts.length - 1];
          else
                mFileName = "REPORT.pdf";

          // download URL and store to strFileName

          // connection to url
      java.net.URL urlReport = new java.net.URL(urls[0]);
          URLConnection urlConn = urlReport.openConnection();
          InputStream streamInput = urlConn.getInputStream();
          BufferedInputStream bufferedStreamInput = new BufferedInputStream(streamInput);
          FileOutputStream outputStream = myActivity.openFileOutput(mFileName,Context.MODE_WORLD_READABLE); // must be world readable so external Intent can open!
          while ((nRead = bufferedStreamInput.read(dataBuffer)) > 0)
                outputStream.write(dataBuffer, 0, nRead);
          streamInput.close();
          outputStream.close();
      }
      catch (Exception e)
      {
       Log.e("myApp", e.getMessage());
       mError = e.getMessage();
       return (1);
      }

     return (0);
    }

    //-------------------------------------------------------------------------
    // PreExecute - UI thread setup
    //-------------------------------------------------------------------------

    @Override
    protected void onPreExecute()
    {
     // show "Downloading, Please Wait" dialog
     mWorkingDialog = ProgressDialog.show(myActivity, "", "Downloading PDF Document, Please Wait...", true);
     return;
    }

    //-------------------------------------------------------------------------
    // PostExecute - UI thread finish
    //-------------------------------------------------------------------------

    @Override
    protected void onPostExecute (Integer result)
    {
         if (mWorkingDialog != null)
      {
       mWorkingDialog.dismiss();
       mWorkingDialog = null;
      }

         switch (result)
         {
         case 0:                            // a URL

            // Intent to view download PDF
            Uri uri  = Uri.fromFile(myActivity.getFileStreamPath(mFileName));

            try
            {
                Intent intentUrl = new Intent(Intent.ACTION_VIEW);
                intentUrl.setDataAndType(uri, "application/pdf");
                intentUrl.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myActivity.startActivity(intentUrl);
            }
            catch (ActivityNotFoundException e)
            {
                Toast.makeText(myActivity, "No PDF Viewer Installed", Toast.LENGTH_LONG).show();
            }

            break;

        case 1:                         // Error

            Toast.makeText(myActivity, mError, Toast.LENGTH_LONG).show();
            break;

        }

    }

}