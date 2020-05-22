[tmp]$ mkdir noprovided-base
[tmp]$ cd noprovided-base/
[noprovided-base]$ java -jar ~/jetty-home-9.4.22.v20191022/start.jar \
  --create-startd \
  --add-to-start=http,deploy,webapp
MKDIR : ${jetty.base}/start.d
INFO  : webapp          initialized in ${jetty.base}/start.d/webapp.ini
INFO  : server          transitively enabled, ini template available with --add-to-start=server
INFO  : security        transitively enabled
INFO  : servlet         transitively enabled
INFO  : http            initialized in ${jetty.base}/start.d/http.ini
INFO  : threadpool      transitively enabled, ini template available with --add-to-start=threadpool
INFO  : bytebufferpool  transitively enabled, ini template available with --add-to-start=bytebufferpool
INFO  : deploy          initialized in ${jetty.base}/start.d/deploy.ini
MKDIR : ${jetty.base}/webapps
INFO  : Base directory was modified

[noprovided-base]$ ls -la
total 16
drwxr-xr-x  4 joakim joakim 4096 Nov 13 08:09 ./
drwxr-xr-x 13 joakim joakim 4096 Nov 13 08:08 ../
drwxr-xr-x  2 joakim joakim 4096 Nov 13 08:09 start.d/
drwxr-xr-x  2 joakim joakim 4096 Nov 13 08:09 webapps/