indexOf("BarackObama", "rac"):
    "BarackObama".substring(0, 3).equals("rac") -> false
    return 1 + indexOf("BarackObama".substring(1, 11), "rac")

indexOf("arackObama", "rac"):
    "arackObama".substring(0, 3).equals("rac") -> false
    return 1 + indexOf("arackObama".substring(1, 10), "rac")

indexOf("rackObama", "rac"):
    "rackObama".substring(0, 3).equals("rac") -> true
    return 0;

return 0 + 1 + 1 = 2