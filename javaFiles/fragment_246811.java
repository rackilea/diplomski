ClassPool pool = ClassPool.getDefault();
CtClass liveClass = null;
try {
     liveClass = pool.get("your.package.path.Dummyclass");
} catch (NotFoundException e) {
     logger.error("Template class not found.", e);
}