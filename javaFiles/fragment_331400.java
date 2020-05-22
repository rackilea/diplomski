echo "Hello World"
cnt=`ps -eaflc --sort stime | grep clientApplication.jar |grep -v grep | wc -l`
if(test $cnt -eq 3) ;
then
    echo "Services for Pigeon are already running..."
else
    echo "Starting Services for Pigeon..."
    echo `java -jar clientApplication.jar`
fi