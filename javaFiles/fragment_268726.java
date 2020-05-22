# Get the pidfile.
pid=$(cat /var/run/my-process.pid)

# Wait ten seconds to stop our process.
for count in $(1 2 3 4 5 6 7 8 9 10); do
    sleep 1
    cat "/proc/$pid/cmdline" 2>/dev/null | grep -q java
    test $? -ne 0 && pid="" && break
done

# If we haven't stopped, kill the process.
if [ ! -z "$pid" ]; then
    echo "Not stopping; terminating with extreme prejudice."
    kill -9 $pid
fi