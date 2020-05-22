public <T> void setPosition(T object) {
   Field xField = object.getClass().getField("x");
   Field boxField = object.getClass().getField("boundBox");
   float xpos = (float)xField.get(object);
   BoundingBox box = (BoundingBox)boxField.get(object);
}