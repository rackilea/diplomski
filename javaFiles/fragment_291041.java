root@hectorvp-pc:~# service saslauthd status                                                                                                                   
● saslauthd.service - LSB: saslauthd startup script
   Loaded: loaded (/etc/init.d/saslauthd)
   Active: active (running) since Tue 2016-04-26 12:04:59 BST; 1s ago
     Docs: man:systemd-sysv-generator(8)
  Process: 11569 ExecStop=/etc/init.d/saslauthd stop (code=exited, status=0/SUCCESS)
  Process: 11586 ExecStart=/etc/init.d/saslauthd start (code=exited, status=0/SUCCESS)
   Memory: 2.0M
   CGroup: /system.slice/saslauthd.service
           ├─11606 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5
           ├─11607 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5
           ├─11608 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5
           ├─11609 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5
           └─11610 /usr/sbin/saslauthd -a ldap -c -m /var/run/saslauthd -n 5

Apr 26 12:04:59 hectorvp-pc systemd[1]: Starting LSB: saslauthd startup script...
Apr 26 12:04:59 hectorvp-pc saslauthd[11586]: * Starting SASL Authentication Daemon saslauthd
Apr 26 12:04:59 hectorvp-pc saslauthd[11606]: detach_tty      : master pid is: 11606
Apr 26 12:04:59 hectorvp-pc saslauthd[11606]: ipc_init        : listening on socket: /var/run/saslauthd/mux
Apr 26 12:04:59 hectorvp-pc systemd[1]: Started LSB: saslauthd startup script.
Apr 26 12:04:59 hectorvp-pc saslauthd[11586]: ...done.