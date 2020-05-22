import re

line = re.sub(
           r"\[xxx(.*)xxx\]", 
           "{$1}", 
           line
       )