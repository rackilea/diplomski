// BT Rename
//
final String sNewName = "Syntactics";
final BluetoothAdapter myBTAdapter = BluetoothAdapter.getDefaultAdapter();
final long lTimeToGiveUp_ms = System.currentTimeMillis() + 10000;
if (myBTAdapter != null)
{
    String sOldName = myBTAdapter.getName();
    if (sOldName.equalsIgnoreCase(sNewName) == false)
    {
        final Handler myTimerHandler = new Handler();
        myBTAdapter.enable();
        myTimerHandler.postDelayed(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (myBTAdapter.isEnabled())
                        {
                            myBTAdapter.setName(sNewName);
                            if (sNewName.equalsIgnoreCase(myBTAdapter.getName()))
                            {
                                Log.i(TAG_MODULE, "Updated BT Name to " + myBTAdapter.getName());
                                myBTAdapter.disable();
                            }
                        }
                        if ((sNewName.equalsIgnoreCase(myBTAdapter.getName()) == false) && (System.currentTimeMillis() < lTimeToGiveUp_ms))
                        {
                            myTimerHandler.postDelayed(this, 500);
                            if (myBTAdapter.isEnabled())
                                Log.i(TAG_MODULE, "Update BT Name: waiting on BT Enable");
                            else
                                Log.i(TAG_MODULE, "Update BT Name: waiting for Name (" + sNewName + ") to set in");
                        }
                    }
                } , 500);
    }
}