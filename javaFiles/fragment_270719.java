/**
 * Removes an ami and its snapshot.
 * @param amiID
 * @param snapshotID
 */
public static void removeImage(final String amiID, final AmazonEC2 ec2) {
    if (amiID != null) {
        DescribeImagesResult result = ec2.describeImages(new DescribeImagesRequest().withImageIds(amiID).withOwners(owner));
        if (!result.getImages().isEmpty()) {
            ec2.deregisterImage(new DeregisterImageRequest(amiID));
            for (BlockDeviceMapping blockingDevice : result.getImages().get(0).getBlockDeviceMappings()) {
                if (blockingDevice.getEbs() != null) {
                    ec2.deleteSnapshot(new DeleteSnapshotRequest().withSnapshotId(blockingDevice.getEbs().getSnapshotId()));
                }
            }
        }
    }
}