while (1) {
    sock = accept(listensock, NULL, NULL);
    printf("client connected to child thread %i with pid %i.\n", pthread_self(), getpid());

    nread = 0;
    while(nread >= 0) {
        nread = recv(sock, buffer, 25, 0);
        if (nread >= 0) {
            buffer[nread] = '\0';
            printf("%s\n", buffer);
            send(sock, buffer, nread, 0);
        }
    }
    close(sock);
    printf("client disconnected from child thread %i with pid %i.\n", pthread_self(), getpid());