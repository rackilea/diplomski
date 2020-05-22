rule "Raise the alarm when we have one or more fires"
    when
exists Fire()
then 
    Alarm $alarm = new Alarm();
    $alarm.RingBell();
    insert( $alarm );  
end