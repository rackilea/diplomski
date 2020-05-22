while(true)
{
    getDisplay().asyncExec(new Runnable() {
        lblNewLabel_1.setText(Calendar.getInstance().getTime().toString());
    });

    Thread.sleep(1000);
}