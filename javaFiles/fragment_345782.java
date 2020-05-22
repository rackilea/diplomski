case R.id.imageButtonServer:
    {
        textView = (TextView)findViewById(R.id.tvUserServerResponse);
        new HttpPostDemo().execute(textView, editText2);
        break;
    }