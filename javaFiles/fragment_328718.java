while( $data = $button->getNextSelectedRecord() )
{
    // Send only if email field not empty
    if( $data["EMAIL_FIELD"] ) {
        // This no longer should be an array of emails
        $email = $data["EMAIL_FIELD"];
        $body = $data["MESSAGE_FIELD"];
        $subject = "";
        // Email will be sent for each record
        $arr = runner_mail(array('to' => $email, 'subject' => $subject, 'body' => $body));
    }
}