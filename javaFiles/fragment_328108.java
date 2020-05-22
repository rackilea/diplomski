S3Find s3Find = new S3Find(topdir).withRecurse(true);
try {
    for (S3URL f : s3Find) {
        ...
    }
} finally {
    s3Find.close();
}