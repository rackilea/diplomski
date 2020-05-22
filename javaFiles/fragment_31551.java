int x = 5;

StringBuilder sb = new StringBuilder(); //You need import java.util.StringBuilder

for (int i = 1; i <= 5; i++) {
    sb.append(i);
    if (i!=x) {
        sb.append(',');
    }
}

String result = sb.toString(); //Here will be "1,2,3,4,5"