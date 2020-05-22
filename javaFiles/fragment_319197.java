echo Parent running
while true; do
  ./a.sh &
  pid=$!
  echo Child running as $pid
  sleep 2
  if [ "`ps -p $pid`" != "" ]; then
    sh -c "/bin/kill $pid" >/dev/null 2>&1 
    echo Killed $pid
  fi
done