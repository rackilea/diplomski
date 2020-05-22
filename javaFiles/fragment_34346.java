"wigData": {
    "wig": [{
            "parentWig": "",
            "wigName": "testing wig 1",
            "wigStart": "01/08/2017",
            "wigFromx": "1",
            "wigToy": "123",
            "wigEnd": "31/08/2017",
            "wigAchievementType": "number"
        }, {
            "parentWig": "",
            "wigName": "testing wig 2",
            "wigStart": "01/08/2017",
            "wigFromx": "1",
            "wigToy": "123",
            "wigEnd": "31/08/2017",
            "wigAchievementType": "number"
        }
    ]
}

class WigData {
    private List<Wig> wig;
    // setter getter
}

class Wig {
    private String parentWig;
    private String wigName;
    private Date wigStart;
    private Date wigFromx;
    private BigDecimal wigToy;
    private String wigAchievementType;
// setter getter
}