// Get node
NodeMetadata node = Iterables.getOnlyElement(nodes);

// Get AWS EC2 API
EC2Api ec2Api = computeServiceContext.unwrapApi(EC2Api.class);

// Create 100 GiB Volume
Volume volume = ec2Api.getElasticBlockStoreApi().get()
        .createVolumeInAvailabilityZone(zoneId, 100);

// Attach to instance
Attachment attachment = ec2Api.getElasticBlockStoreApi().get()
        .attachVolumeInRegion(region, volume.getId(), node.getId(), "/dev/sdx");