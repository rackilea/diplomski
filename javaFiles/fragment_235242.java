int i = 0;
int j = 0;
int k = 0;
int l = 0;
System.out.println("0-29 30-39 40-69 70-100");
while (i<starsfrom0to29 || j < starsfrom30to39 || k < starsfrom40to69 || l < starsfrom70to100) {
    if (i<starsfrom0to29) {
        System.out.print(" *   ");
        i++;
    } else {
        System.out.print("     ");
    }
    if (j<starsfrom30to39) {
        System.out.print("  *   ");
        j++;
    } else {
        System.out.print("      ");
    }
    if (k<starsfrom40to69) {
        System.out.print("  *   ");
        k++;
    } else {
        System.out.print("      ");
    }
    if (l<starsfrom70to100) {
        System.out.println("  *   ");
        l++;
    } else {
        System.out.println("");
    }
}