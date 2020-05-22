MyRunnable runnable = new MyRunnable();
Display.getDefault().syncExec(runnable);

System.out.println(runnable.getText());


private class MyRunnable implements Runnable
{
    String myString;

    @Override
    public void run()
    {
       //Here you can also get the text from your Text-Object
        myString = "MyText";
    }

    String getText()
    {
        return myString;
    }
}