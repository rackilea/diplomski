sock.sun_family = AF_UNIX;
sock.sun_path[0] = '\0'
strcpy(&sock.sun_path[1], "my_sock");
sock_fd = socket(AF_UNIX, SOCK_STREAM, 0);
len_addr = offsetof(struct sockaddr_un, sun_path) + strlen("my_sock") + 1;
res = connect(sock_fd, (struct sockaddr *)&sock, len_addr);