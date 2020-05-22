Calendar c = Calendar.getInstance(); 
int m = calendar.get(Calendar.MINUTE);
long start = System.currentTimeMillis();
int remain=0;
if (m<15)
{
 remain = 15-m;
}
else if (m<30)
{
 remain = 30-m;
}
else if (m<45)
{
 remain = 45-m;
}
else
{
 remain = 60-m;
}
remain=start + remain*60*1000// convert it to milisecond and plus it to current time;