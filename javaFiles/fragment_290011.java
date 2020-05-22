is_running=true;
while (is_running & !is_stopping)
{
   do_something();
   sleep();
}
is_stopping=false;
is_running=false;