index
update item set
category=?,...........1......ps.setString(1,u.getCategory());
name=?,...............2......ps.setString(2,u.getName());
brand=?,..............3......ps.setString(3,u.getBrand());
type=?,...............4......ps.setString(4,u.getType());
style=?,..............5......ps.setString(5,u.getStyle());
colour=?,.............6......ps.setString(6,u.getColour());
itemSize=?,...........7......ps.setString(7,u.getItemSize());
width=?,..............8......ps.setString(8,u.getWidth());
height=?,.............9......ps.setString(9,u.getHeight());
price=?,.............10......ps.setString(10,u.getPrice());
gender=?,............11......ps.setString(11,u.getGender());
images=?.............12......ps.setBlob(12,u.getImages()); 
where itemId=?.......13......ps.setString(13,u.getItemId());