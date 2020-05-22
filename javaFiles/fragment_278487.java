if(connect(sock, (SOCKADDR*)&sin, sizeof(sin)) != SOCKET_ERROR)
{
    cout << "connection" << endl;

    // the result of 'recv()' is either SOCKET_ERROR or
    // the number of bytes received.  don't though away
    // the return value.
    const int result = recv(sock, buffer, sizeof(buffer), 0);
    if(result != SOCKET_ERROR)
    {
        // use length (in bytes) returned by 'recv()'
        // since buffer is not null terminated.
        string s(buffer,result);

        // 's' is in UTF-8 no converstion to wide strings
        // should be necessary.
        cout << "message: '" << s << "'." << endl;
    }

    closesocket(sock);
}
WSACleanup();