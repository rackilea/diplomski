if (thread instanceof ThreadPoolExecutor) {
    System.out.println(
        "Pool size is now " +
        ((ThreadPoolExecutor) pool).getActiveCount()
    );
}