public TextField getPinNo()
{
    if(pinno==null)
    {
        pinno= new TextField("PIN", null,4, TextField.PASSWORD | TextField.NUMERIC);

    }
    return pinno;
}