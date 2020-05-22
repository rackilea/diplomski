public class CaseClass {

    public static CaseClass apply(int p0) {
        return:CaseClass(invokevirtual:CaseClass(CaseClass$::apply, getstatic:CaseClass$(CaseClass$::MODULE$), p0:int))
    }

    public int value() {
        return:int(getfield:int(CaseClass::value, this:CaseClass))
    }

    // the rest is omitted
}