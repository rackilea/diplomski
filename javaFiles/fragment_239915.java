public static void main(String[] args) {
    String[] str = {"CDRW","CDWR","CRDW","CRWD","CWDR","CWRD",
                    "DCRW","DCWR","DRCW","DRWC","DWCR","DWRC",
                    "RCDW","RCWD","RDCW","RDWC","RWCD","RWDC",
                    "WCDR","WCRD","WDCR","WDRC","WRCD","WRDC"};
    for(String s: str){
        System.out.println(check(s));
    }       
}