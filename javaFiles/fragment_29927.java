public class SplitURL {
    public static void main(String[] args) {
        String url = "https://localhost:8080/prodpat/admin/page1";
        String[] urlSplitData = url.split("[^A-Za-z0-9]");
        System.out.println(java.util.Arrays.toString(urlSplitData));

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<urlSplitData.length; i++) {
            if(urlSplitData[i].trim().length() != 0) {
                sb.append(urlSplitData[i]+"_");
            }
        }
        System.out.println(java.util.Arrays.toString(sb.toString().split("_")));
    }
}