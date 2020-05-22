NSDate *today = [NSDate date];
NSDate *now = [NSDate date];
NSCalendar *gregorian = [[NSCalendar alloc]
                         initWithCalendarIdentifier:NSCalendarIdentifierGregorian];
NSDateComponents *weekdayComponents =
[gregorian components:(NSDayCalendarUnit | NSWeekdayCalendarUnit) fromDate:today];
NSInteger day = [weekdayComponents day];
NSInteger weekday = [weekdayComponents weekday];

[today timeIntervalSince1970 ]-[now timeIntervalSince1970]/(1000*60*60*24.0)+1;