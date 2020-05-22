enum CellValue {
    Undefined, One, Two, Three, Four, Five, Six, Seven, Eight, Nine;
    public static CellValue fromInteger(int x) {
        switch (x) {
        case 0:
            return Undefined;
        case 1:
            return One;
        case 2:
            return Two;
        case 3:
            return Three;
        case 4:
            return Four;
        case 5:
            return Five;
        case 6:
            return Six;
        case 7:
            return Seven;
        case 8:
            return Eight;
        case 9:
            return Nine;
        }
        return null;
    }

    public static int toInteger(CellValue value) throws Exception {
        switch (value) {
        case Undefined:
            throw new Exception("Undefined cell value");
        case One:
            return 1;
        case Two:
            return 2;
        case Three:
            return 3;
        case Four:
            return 4;
        case Five:
            return 5;
        case Six:
            return 6;
        case Seven:
            return 7;
        case Eight:
            return 8;
        case Nine:
            return 9;
        }
        throw new Exception("Undefined Cell Value");
    }
}