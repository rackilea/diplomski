final Annotation[] annos = m.getAnnotations();

for (Annotation anno : annos) {
    if (anno instanceof Hashingsnr) {
        final Hashingsnr impl = (Hashingsnr)anno;
        System.out.println(impl.str() + " " + impl.yuiop() + " " + impl.fdfd());
    }
}