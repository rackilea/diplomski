int i = 0;
for (int Image : images_item){
    Helper helper = new Helper(images_item[i]);
    adapter.add(helper);
    i++;
}