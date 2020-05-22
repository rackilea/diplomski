start_day=22
end_day=$1
sar_path="/var/log/sa"

start_time=14
end_time=17

echo "start_day = $start_day - end_day = $end_day"
echo "start_time = $start_time - end_time = $end_time"

if [ $start_day -eq $end_day ]; then
        echo "sar -i 900 -f $sar_path/sa$start_day -s $start_time:00:00 -e $end_time:00:00"
elif [ "$(($start_day + 1))" -eq $end_day ]; then
        echo "sar -i 900 -f $sar_path/sa$start_day -s $start_time:00:00 -e 23:59"
        echo "sar -i 900 -f $sar_path/sa$end_day -s 00:00:00 -e $end_time:00:00"
elif [ $start_day -gt $end_day ]; then
        last_day=$(ls -1 $sar_path/sa[0-9]* | tail -1)
        last_day=$(basename $last_day | grep -o [0-9]*)
        echo "sar -i 900 -f $sar_path/sa$start_day -s $start_time:00:00 -e 23:59"
        for i in $(seq $(($start_day +1)) $(($last_day)))
        do
                echo "sar -i 900 -f $sar_path/sa$i -s 00:00:00 -e 23:59:00"
        done
        for i in $(seq 1 $(($end_day -1)))
        do
                echo "sar -i 900 -f $sar_path/sa$i -s 00:00:00 -e 23:59:00"
        done
        echo "sar -i 900 -f $sar_path/sa$end_day -s 00:00:00 -e $end_time:00:00"
else
        echo "sar -i 900 -f $sar_path/sa$start_day -s $start_time:00:00 -e 23:59"
        for i in $(seq $(($start_day +1)) $(($end_day -1)))
        do
                echo "sar -i 900 -f $sar_path/sa$i -s 00:00:00 -e 23:59:00"
        done
        echo "sar -i 900 -f $sar_path/sa$end_day -s 00:00:00 -e $end_time:00:00"
fi