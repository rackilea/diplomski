...
if (!oldImpl)
    impl.connect(epoint, timeout);
else if (timeout == 0) {
    if (epoint.isUnresolved())
        impl.connect(addr.getHostName(), port);
    else
        impl.connect(addr, port);
...