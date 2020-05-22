from datetime import datetime
from pytz import timezone 

now = datatime.datetime.now();
gmt_time = now.replace(tzinfo=timezone('GMT'))
print(gmt_time.strftime("%a, %d %b %Y %H:%M:%S %z"))