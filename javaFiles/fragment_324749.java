unsigned char buf[4096];  // nb: no "new", and sizeof *does* work on arrays

int filefd = open(..., O_WRONLY | O_CREAT);
while (rbytes > 0) {
    int n = recv(sockfd, buf, sizeof buf, 0);
    if (n > 0) {
        int w = write(filefd, buf, n); // assumes file writes are all or nothing
        if (w < 0) {
            // error
        }
        rbytes -= n;
    } else if (n == 0) {
        // closed
    } else {
        // error
    }
}

close(filefd);
close(sockfd);

// no need to deallocate buf as it's on the stack, not the heap