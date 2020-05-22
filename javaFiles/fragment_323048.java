#  Pattern.compile("(?i)\\./\\s+ADD\\s+name\\s*=");

 (?i)      # Case insensitive modifier
           #     for all subsequent alpha literals
 \.        # literal dot
 /         # literal forward slash
 \s+       # 1 or more whitespace characters
 ADD       # 'ADD'
 \s+       # 1 or more whitespace characters 
 name      # 'name'
 \s*       # 0 or more whitespace characters
 =         # '='