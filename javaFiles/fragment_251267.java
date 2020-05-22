public class Status {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void getStatus() {
        String status = IOHandler.getHtmlSource("http://status.mojang.com/check");
        String[] statusArray = status.split(",");
        String a = "";

        for (int i = 0; i < statusArray.length; i++) {
            a = statusArray[i].replaceAll("\\[", "").replaceAll("\\]", "")
                    .replaceAll("\\{", "").replaceAll("\"", " ")
                    .replaceAll("\\:", "-").replaceAll("\\}", "")
                    .trim();

            if (a.contains("green")) {
                a = a.replaceAll(" - green", "");
                mc.thePlayer.addChatMessage(Variables.ChatBGreen + a);
            } else if (a.contains("yellow")) {
                a = a.replaceAll(" - yellow", "");
                mc.thePlayer.addChatMessage(Variables.ChatYellow + a);
            } else if (a.contains("red")) {
                a = a.replaceAll(" - red", "");
                mc.thePlayer.addChatMessage(Variables.ChatDRed + a);
            } else {
                mc.thePlayer.addChatMessage(Variables.ChatDRed + "ERROR");
            }
        }
    }
}