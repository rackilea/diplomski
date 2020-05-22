public class SplitTest {
    public static void main(String[] args) {

        String[] array = splitAddress("http://stackoverflow.com/questions");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    static String[] splitAddress(String address) {
        String[] split = address.split("://");
        String[] split1 = split[1].split(".com");
        if (split1.length < 2) {
            String[] end = new String[2];
            end[0] = split[0];
            end[1] = split1[0];
            return end;
        } else {
            String[] e = new String[3];
            e[0] = split[0];
            e[1] = split1[0];
            e[2] = split1[1];
            return e;

        }
    }
}