Window window = new Window();
window.setIsModal(true);
window.setWidth(800);
window.setHeight(500);
window.setAutoCenter(true);
window.setShowModalMask(true);

window.show();

final HLayout message = new HLayout();
message.setWidth(400);
message.setHeight(30);
message.addMember(new Label("hey you"));

message.setBackgroundColor("yellow");

message.bringToFront();
message.show();