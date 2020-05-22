import ceylon.language {
    CInteger=Integer
}
import java.lang {
    JInteger=Integer
}

shared void run() {
    CInteger ci1 = 1;
    JInteger ji1 = JInteger(ci1);
    JInteger ji2 = JInteger.valueOf(ci1);
    CInteger ci2 = ji1.intValue();
}