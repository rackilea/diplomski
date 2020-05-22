public static void upload(HttpServletRequest request, Part part, S3Service s3Service, S3Bucket s3Bucket) 
        throws S3ServiceException, NoSuchAlgorithmException, IOException
{
    S3Object s3Object = new S3Object();
    s3Object.setDataInputStream(part.getInputStream());
    s3Object.setKey(part.getName());
    s3Object.setContentLength(part.getSize());
    s3Object.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
    s3Service.putObject(s3Bucket, s3Object);
}

        public static void update(HttpServletRequest request) 
        throws S3ServiceException, ServiceException, NoSuchAlgorithmException, IOException, IllegalStateException, ServletException
{
    AWSCredentials awsCredentials = (AWSCredentials) request.getSession().getAttribute("awsCredentials");
    S3Service s3Service = (S3Service) request.getSession().getAttribute("s3Service");
    S3Bucket s3Bucket = (S3Bucket) request.getSession().getAttribute("s3Bucket");
    String bucketName = (String) request.getSession().getAttribute("bucketName");

    String prefix = "uploads/";
    String delimiter = null;
    S3Object[] filteredObjects = s3Service.listObjects(bucketName, prefix, delimiter);

    Collection<Part> allParts = request.getParts();
    Collection<Part> selectedParts = new ArrayList<Part>();
    Collection<String> keys = new ArrayList<String>();

    for (Part part : allParts)
    {
        if (part.getSize()>1 && part.getSize()<10485760)
        {
            selectedParts.add(part);
        }
    }

    for (int o = 0; o < filteredObjects.length; o++)
    {
        String keyObject = filteredObjects[o].getName();
        keys.add(keyObject);
    }

    if (selectedParts.size() > 0)
    {
        for (Part part : selectedParts)
        {
            if (keys.contains(part.getName()))
            {
                s3Service.deleteObject(s3Bucket, part.getName());
                upload(request, part, s3Service, s3Bucket);
            }

            else
            {
                selectedParts.remove(part);
            }
        }
    }

    else
    {
        String ex = "No file to update.";
        exceptions.add(ex);
    }
}