List<Integer> objects = new ArrayList<Integer>();
objects.add(R.id.imageView1);  
objects.add(R.id.imageView2);       
objects.add(R.id.imageView3); 
objects.add(R.id.imageView4);
// Shuffle the collection
Collections.shuffle(objects); 

ImageView pic1 = (ImageView ) findViewById(objects.get(0));        
ImageView pic2 = (ImageView ) findViewById(objects.get(1));        
ImageView pic3 = (ImageView ) findViewById(objects.get(2));
ImageView pic4 = (ImageView ) findViewById(objects.get(3));