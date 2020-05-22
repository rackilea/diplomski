$ cat Dockerfile 
FROM busybox
ARG what
ENV what $what
RUN echo ${what} > /tmp/${what}
ENTRYPOINT cat /tmp/${what}

$ docker run -ti $(docker build -q --build-arg=what=test . ) 
test