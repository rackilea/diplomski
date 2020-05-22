// In the declaration section of your class.
private static boolean isScreenShotTaken = false;

// In the code.
btnsend.setOnClickListener
(
    new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if(!isScreenShotTaken)
            {
                Bitmap bitmap = takeScreenshot();
                saveBitmap(bitmap);
                isScreenShotTaken = true;
            }
        }
    }
);

blankcard.setOnLongClickListener
(
    new OnLongClickListener()
    {
        @Override
        public boolean onLongClick(View arg0)
        {
            if(!isScreenShotTaken)
            {
                Bitmap bitmap = takeScreenshot();
                saveBitmap(bitmap);
                isScreenShotTaken = true;
            }
        }
    }
);