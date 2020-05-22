stream.peek( p -> {
    if ("YourID".equals(p.getID()))
    {
         p.setQuantity(newQuantity);
    }
});