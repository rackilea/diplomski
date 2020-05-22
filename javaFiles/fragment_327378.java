public static void main(final String[] args) throws Exception{
    final Thingy thingy = new Thingy();
    final BeanWrapper wrapper = new BeanWrapperImpl(thingy);
    for(final PropertyDescriptor descriptor : wrapper.getPropertyDescriptors()){
        System.out.println(descriptor.getName() + ":"
            + descriptor.getReadMethod().invoke(thingy));
    }
}