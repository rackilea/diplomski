public static readonly DateTime UnixEpoch
    = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);

public DateTime FromMillisecondsSinceUnixEpoch(long milliseconds)
{
     return UnixEpoch.AddMilliseconds(milliseconds);
}