% Convert dates in MATLAB from SQLServer => MySQL

% Datetime: byte order is NOT reversed & start date is 1/1/1900
str = regexprep(str, 'CAST\(0x(........)(........) AS DateTime\)', ...
                     'CAST(''1900-01-01'' + INTERVAL 0x$1 DAY + INTERVAL 0x$2/300 second as datetime)');

% Date: byte order is reversed & start date is 1/1/0001
str = regexprep(str, 'CAST\(0x(..)(..)(..)(..) AS Date\)', ...
                     'CAST(''0001-01-01'' + INTERVAL 0x$4$3$2$1 DAY as date)');