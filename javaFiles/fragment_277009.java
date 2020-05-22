$ch = curl_init();

curl_setopt($ch, CURLOPT_URL, $urlOfFormSubmission);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, array(

        "field1"=>"data1",
        "field2"=>"data2"

    ));

curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

$contents = curl_exec($ch);