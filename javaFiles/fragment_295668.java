sendMail {
    multipart true //has to be there as first line

    from "sender@somedomain.com"
    to "receiver@somedomain.com"
    subject "Report - Sample"
    html htmlStr

    //Use raw byte array instead of string
    inline 'imageId', 'image/png', byteArray
}