import Foundation

let date = Date();

let dateFormatter = DateFormatter()
dateFormatter.timeStyle = .medium 
dateFormatter.dateStyle = .none // ignore date
dateFormatter.timeZone = TimeZone(secondsFromGMT: 2*60*60)
let localDate = dateFormatter.string(from:date)

print("UTC Time: \(date)")  // 2018-10-18 08:15:07 +0000
print("Local Time: \(localDate)") // 10:15:07 AM