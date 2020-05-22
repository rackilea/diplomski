qr{
    ^           # Start of text
    ftp:        # Protocol
    //          # Double slash
    ([^:]+)     # $1 = User Name
    :           # Colon
    ([^@]+)     # $2 = Password
    @           # AT sign
    (.*?)       # $3 = Server name
    /           # Single slash
    (.*?)       # $4 = Directory name
    (\?.*)?     # Question mark ends URI
    $           # End of text
}x;