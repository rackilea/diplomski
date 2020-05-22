int sockfd, sockfd2;
struct addrinfo hints, *servinfo, *p;
struct addrinfo hints2, *servinfo2, *p2;
int rv, rv2;
 //Opening socket
memset(&hints, 0, sizeof(hints));
memset(&hints2, 0, sizeof(hints2));
hints.ai_family = AF_UNSPEC;
hints.ai_socktype = SOCK_STREAM;
hints2.ai_family = AF_UNSPEC;
hints2.ai_socktype = SOCK_STREAM;

if ((rv = getaddrinfo(argv[1], argv[3], &hints, &servinfo)) != 0) {
    fprintf(stderr, "tpgetaddrinfo: %s\n", gai_strerror(rv));
exit(1);
}

if ((rv2 = getaddrinfo(argv[2], argv[4], &hints2, &servinfo2)) != 0) {
fprintf(stderr, "rsgetaddrinfo: %s\n", gai_strerror(rv2));
exit(1);
}

for (p = servinfo; p != NULL; p = p->ai_next) {
if ((sockfd = socket(p->ai_family, p->ai_socktype, p->ai_protocol)) == -1) {
    perror("tpsocket");
    continue;
}

if (connect(sockfd, p->ai_addr, p->ai_addrlen) == -1) {
    perror("tpconnect");
    close(sockfd);
    continue;
}

break;
}

for (p2 = servinfo2; p2 != NULL; p2 = p2->ai_next) {
if ((sockfd2 = socket(p2->ai_family, p2->ai_socktype, p2->ai_protocol)) == -1) {
    perror("rssocket");
    continue;
}

if (connect(sockfd2, p2->ai_addr, p2->ai_addrlen) == -1) {
    perror("rsconnect");
    close(sockfd2);
    continue;
}

break;
}

if (p == NULL) {
fprintf(stderr, "failed to connect tpserver\n");
exit(2);
}

if (p2 == NULL) {
fprintf(stderr, "failed to connect rsserver\n");
exit(2);
}

freeaddrinfo(servinfo);
freeaddrinfo(servinfo2);