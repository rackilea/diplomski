String s = "Announcements/announcement_id/Comments/comment_id/Replies/reply_id";
String[] h = s.split("\\/");
switch (h.length) {
case 2:
    System.out.println(h[1]);
    break;
case 4:
    System.out.println(h[1] + " " + h[3]);
    break;
case 6:
    System.out.println(h[3] + " " + h[5]);
    break;
default:
    break;

}