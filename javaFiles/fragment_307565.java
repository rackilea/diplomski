public static Intent prepare( String to, String cc, String subject, String content, String messageType )
{

    if (messageType==null){ messageType = "plain/text"; }

    Intent preparedIntent = new Intent( Intent.ACTION_SEND );
    preparedIntent.setType( messageType );

    if (to!=null) {
        preparedIntent.putExtra(Intent.EXTRA_EMAIL, new String[ ] 
        { 
            to
        });
    }

    if (cc!=null) {
        preparedIntent.putExtra(Intent.EXTRA_CC, new String[ ]
        {
            cc
        });
    }
    preparedIntent.putExtra(Intent.EXTRA_SUBJECT, subject);

    preparedIntent.putExtra(Intent.EXTRA_TEXT, content);

    return preparedIntent;
}