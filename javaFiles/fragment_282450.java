MultiButton mb = new MultiButton(order);

switch (status) {
    case "completed":
        //Change the second line to color green
        setLine2Color(mb, 0x00ff00);
        mb.setTextLine2(status);
        break;
    case "processing":
        //Change the second line to color yellow
        setLine2Color(mb, 0xffff00);
        mb.setTextLine2(status);
        break;
    case "cancelled":
        //Change the second line to color red
        setLine2Color(mb, 0xff0000);
        mb.setTextLine2(status);
        break;
    default:
        mb.setTextLine2(status);
        break;
}