Transaction tx = session.beginTransaction();
Item item = new Item();
//added save here to attach the object to persistance context.
// (This might be optional)
session.save(item);              

Set images = new HashSet();
images.add("C:\\");
images.add("D:\\");
item.setImages(images);           
List<Data> data = new ArrayList<Data>();
Data a = new Data();
a.setFirstName("John");
a.setLastName("Smith");
//added save here to attach the object to persistance context.
//this is required without cascading settings
session.save(a)                 

data.add(a);
item.setData(data);
session.save(item);
tx.commit();//-->Exception here
session.close();