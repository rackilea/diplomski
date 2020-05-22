protected void onPostExecute(Document result)
    {

        if(tl.getChildAt(1) == null)
        {
            //do some code              
        }
        else
        {
            int u = 20;
            while(tl.getChildAt(1) != null)
            {
                if(tl.getChildAt(u) != null)
                    tl.removeViewAt(u);
                u--;
                }
                //do same code over again as above.

                }
            }
        }