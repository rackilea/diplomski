public class Hours {
    _1, _2, _3, // etc.
}

public class Hour {
    public Hour(Hours hour) { // no need for runtime check here, can not be wrong}
}

Hour hour = new Hour(Hours._3);