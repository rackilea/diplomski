public class CaseTernIf
{
    public static int aORbIf (int a) {
        if (a == 2) 
            return 4;
        else    return 5;
    }

    public static int aORbTern (int a) {
        return  (a == 2) ? 4 : 5;
    }

    public static int aORbCase (int a) {
        switch (a) {
            case 2:  return 4;
            default: return 5; 
        }
    }
}